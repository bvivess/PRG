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
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

public class GestorTaller {
    final String MYSQL_CON = "c:\\temp\\mysql.con";
    UtilBBDD gestorBBDD = new UtilBBDD();
    
    Set<Client> clients = new HashSet<>();
    Set<Vehicle> vehicles = new HashSet<>();
    Map<Integer, Reparacio> reparacions = new HashMap<>();

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
                        afegeixClient(clients, new Client( Integer.parseInt(parts[0].trim()),
                                                           parts[1].trim(),
                                                           parts[2].trim()) );
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant clients CVS: " + e.getMessage());
        }
    }
    
    public void afegeixClient(Set<Client> clients, Client client) {
        clients.add(client);
    }
    
    private Client cercaClient (Client c) throws NoSuchElementException {
        for (Client client : this.clients) 
            if (c.equals(client))
                return client;
        
        throw new NoSuchElementException("Client no trobat a la llista.");
    }
 
    // --- CÀRREGA VEHICLES
    public void carregaVehicles(String path) throws SQLException, IOException {
        carregaVehiclesBBDD(this.vehicles);
        carregaVehiclesCSV(this.vehicles, path);

        System.out.println(this.vehicles);
    }

    private void carregaVehiclesBBDD(Set<Vehicle> vehicles) throws SQLException, IOException {
        String sql = "SELECT matricula, marca, model, client_id FROM vehicles";
        
        try ( Connection connexio = gestorBBDD.getConnectionFromFile(MYSQL_CON);
              ResultSet resultSet = gestorBBDD.executaQuerySQL(connexio, sql) ) { 
            
            while (resultSet.next())
                afegeixVehicle( vehicles, new Vehicle( resultSet.getString("matricula"),
                                                       resultSet.getString("marca"), 
                                                       resultSet.getString("model"),
                                                       cercaClient( new Client(resultSet.getInt("client_id"), ".", ".") ) )
                              );
            
        } catch (SQLException e) {
            System.err.println("Error carregant vehicles BBDD: " + e.getMessage());
        }
    }
        
    private void carregaVehiclesCSV(Set<Vehicle> vehicles, String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.startsWith("#") && !linia.isBlank()) {
                    String[] parts = linia.split(",");
                 
                    afegeixVehicle( vehicles, new Vehicle( parts[0].trim(), 
                                                           parts[1].trim(), 
                                                           parts[2].trim(), 
                                                           cercaClient( new Client(Integer.parseInt(parts[3].trim()), ".", ".") ) ) );
                }
            }
        }
    }

   public void afegeixVehicle(Set<Vehicle> vehicles, Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    
    private Vehicle cercaVehicle (Vehicle v) throws NoSuchElementException {
        for (Vehicle vehicle : this.vehicles) 
            if (v.equals(vehicle))
                return vehicle;
        
        throw new NoSuchElementException("Vehicle no trobat a la llista.");
    }
    
    // CARREGA REPARACIONS  
    public void carregaReparacions(String path) throws SQLException, IOException {
        carregaReparacionsBBDD(this.reparacions);
        carregaReparacionsCSV(this.reparacions, path);

        System.out.println(this.reparacions);
    }
    
    private void carregaReparacionsBBDD(Map<Integer, Reparacio> reparacions) throws SQLException, IOException {
        String sql = "SELECT r.id id, dataEntrada, matricula, cost, descripcio, estat FROM reparacions r, tasques t where r.id = reparacio_id;";
        
        try ( Connection connexio = gestorBBDD.getConnectionFromFile(MYSQL_CON);
              ResultSet resultSet = gestorBBDD.executaQuerySQL(connexio, sql) ) { 
            
            Reparacio reparacio = null;
            while (resultSet.next()) {
                reparacio = reparacions.get(resultSet.getInt("id"));
                if ( reparacio == null)
                    reparacio = new Reparacio( resultSet.getInt("id"),
                                               resultSet.getDate("dataEntrada").toLocalDate(),
                                               cercaVehicle( new Vehicle(resultSet.getString("matricula"), ".", ".", null) ),
                                               resultSet.getDouble("cost"),
                                               new ArrayList<>() ); 
                reparacio.getTasques().add( new Tasca(resultSet.getString("descripcio"), null)  );
                afegeixReparacio( reparacions, reparacio );
            }
            
                                                  
        } catch (SQLException e) {
            System.err.println("Error carregant clients BBDD: " + e.getMessage());
        }        
    }

    private void carregaReparacionsCSV(Map<Integer, Reparacio> reparacions, String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.startsWith("#") && !linia.isBlank()) {
                    String[] parts = linia.split(",",5);
                     
                    if (parts.length == 5) {
                        Reparacio reparacio = new Reparacio( Integer.parseInt(parts[0].trim()),
                                                             LocalDate.parse(parts[1].trim()),
                                                             cercaVehicle( new Vehicle(parts[2].trim(), null, null, null) ),
                                                             Double.parseDouble(parts[3].trim()),
                                                             new ArrayList<>() );
                        
                        
                        
                        String[] llistaTasques = parts[4].trim().split(";");
                        for (String llTasques: llistaTasques) {
                            String[] t = llTasques.split(",");
                            
                            reparacio.getTasques().add ( new Tasca(t[0].trim(), EstatReparacio.valueOf(t[1].trim())) );
                        }
                        afegeixReparacio( reparacions, reparacio );
                    }
                }
            }
        }
    }
    
    public void afegeixReparacio(Map<Integer, Reparacio> reparacions, Reparacio reparacio) {
        reparacions.put(reparacio.getId(), reparacio);
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


}