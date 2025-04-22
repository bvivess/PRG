package ACT11_6B.Utils;

import ACT11_6B.Classes.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GestorTaller {
    final String MYSQL_CON = "c:\\temp\\mysql.con";
    UtilBBDD gestorBBDD = new UtilBBDD();
    
    Set<Client> clients = new HashSet<>();
    List<Vehicle> vehicles = new ArrayList<>();
    Map<Integer, Reparacio> reparacions = new HashMap<>();
    Queue<Vehicle> cuaReparacionsPendents = new LinkedList<>();

    // --- CÀRREGA CLIENTS 
    public void carregaClients(String path) throws SQLException, IOException {
        carregaClientsBBDD(this.clients);
        carregaClientsCSV(this.clients, path);

        System.out.println(this.clients);
    }
    
    public void carregaClientsBBDD(Set<Client> clients) throws SQLException, IOException{ 
        String sql = "SELECT id, nom, email FROM clients";
        
        try ( Connection connexio = gestorBBDD.getConnectionFromFile(MYSQL_CON);
              ResultSet resultSet = gestorBBDD.executaQuerySQL(connexio, sql) ) {   
            
            while (resultSet.next())
                afegeixClient( clients, new Client( resultSet.getInt("id"),
                                                    resultSet.getString("nom"), 
                                                    resultSet.getString("email") )
                             );
            
        } catch (SQLException e) {
            System.err.println("Error carregant clients BBDD: " + e.getMessage());
        }
    }

    public void carregaClientsCSV(Set<Client> clients, String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!(linia.isEmpty() || linia.startsWith("#"))) {
                    String[] parts = linia.split(",");
                    if (parts.length == 3) 
                        afegeixClient(clients, new Client( Integer.parseInt(parts[0]),
                                                           parts[1],
                                                           parts[2]) );
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant clients CVS: " + e.getMessage());
        }
    }
    
    public void afegeixClient(Set<Client> clients, Client client) {
        clients.add(client);
    }


    public void carregaVehicles(String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.startsWith("#") && !linia.isBlank()) {
                    String[] p = linia.split(",");
                    Client c = cercaClientPerId(Integer.parseInt(p[3]));
                    vehicles.add(new Vehicle(p[0], p[1], p[2], c));
                }
            }
        }
    }

    public void carregaReparacions(String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.startsWith("#") && !linia.isBlank()) {
                    String[] p = linia.split(",");
                    Vehicle v = cercaVehiclePerMatricula(p[2]);
                    Reparacio r = new Reparacio(
                        Integer.parseInt(p[0]),
                        LocalDate.parse(p[1]),
                        v,
                        p[3],
                        Double.parseDouble(p[4]),
                        EstatReparacio.valueOf(p[5])
                    );
                    reparacions.put(r.getId(), r);
                }
            }
        }
    }

    // Modifica dades
    public void modifica() {
        clients.forEach(c -> {
            c.setNom(c.getNom().toUpperCase());
            c.setEmail(c.getEmail().toLowerCase());
        });

        vehicles.forEach(v -> v.setModel(v.getModel().toUpperCase()));

        reparacions.values().forEach(r -> r.setCost(r.getCost() * 1.05));
    }

    // Desa dades
    public void desaClients(String path) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))) {
            for (Client c : clients) {
                bw.write(c.getId() + "," + c.getNom() + "," + c.getEmail());
                bw.newLine();
            }
        }
    }

    public void desaVehicles(String path) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))) {
            for (Vehicle v : vehicles) {
                bw.write(v.getMatricula() + "," + v.getMarca() + "," + v.getModel() + "," + v.getClient().getId());
                bw.newLine();
            }
        }
    }

    public void desaReparacions(String path) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))) {
            for (Reparacio r : reparacions.values()) {
                bw.write(r.getId() + "," + r.getDataEntrada() + "," + r.getVehicle().getMatricula() + "," + r.getDescripcio() + "," + r.getCost() + "," + r.getEstat());
                bw.newLine();
            }
        }
    }

    // Gestió de la cua
    public void afegirVehicleARevisar(String matricula) {
        Vehicle v = cercaVehiclePerMatricula(matricula);
        cuaReparacionsPendents.offer(v);
    }

    public void processarSeguentVehicle() {
        Vehicle v = cuaReparacionsPendents.poll();
        
        if (v != null) {
            Reparacio nova = new Reparacio(
                reparacions.size() + 1,
                LocalDate.now(),
                v,
                "Diagnòstic inicial",
                0.0,
                EstatReparacio.EN_PROCES
            );
            reparacions.put(nova.getId(), nova);
        }
    }

    // Consultes
    public void mostraClients() {
        clients.stream().sorted(Comparator.comparing(Client::getId)).forEach(System.out::println);
    }

    public void mostraVehicles() {
        vehicles.stream().sorted(Comparator.comparing(Vehicle::getMatricula)).forEach(System.out::println);
    }

    public void mostraReparacions() {
        reparacions.values().stream().sorted(Comparator.comparing(Reparacio::getId)).forEach(System.out::println);
    }

    // Cerca
    private Client cercaClientPerId(int id) {
        return clients.stream().filter(c -> c.getId() == id).findFirst().orElseThrow();
    }

    private Vehicle cercaVehiclePerMatricula(String m) {
        return vehicles.stream().filter(v -> v.getMatricula().equalsIgnoreCase(m)).findFirst().orElseThrow();
    }
}