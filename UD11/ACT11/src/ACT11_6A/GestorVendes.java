package ACT11_6A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

class GestorVendes {
    private List<Client> clients = new ArrayList<>();
    private List<Producte> productes = new ArrayList<>();
    private Map<Integer,Venda> vendes = new HashMap<>();

    private final String url = "jdbc:mysql://localhost:3306/gbd";
    private final String usuari = "root";
    private final String contrasenya = "";

    // --- ALTA DE CLIENTS 
    public void carregaClients(String taula, String path) {
        carregaClientsCSV(path);
        carregaClientsTaula(taula);
    }

    public void carregaClientsCSV(String path) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.substring(0, 1).equals("#")) {
                    String[] parts = linia.split(",");
                    if (parts.length == 3) 
                        afegeixClient(new Client(Integer.parseInt(parts[0]), parts[1], parts[2]));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant clients: " + e.getMessage());
        }
    }
    
    public void carregaClientsTaula(String taula) { 
        
    }
    
    public void afegeixClient(Client client) {
        if (clients.indexOf(client.getId()) == -1 )
            clients.add(client);
    }
    
    // --- ALTA DE CLIENTS 
    public void carregaProductes(String taula, String path) {
        carregaProductesCSV(path);
        carregaProductesTaula(taula);
    }
    
    public void carregaProductesCSV(String path) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.substring(0, 1).equals("#")) {
                    String[] parts = linia.split(",");
                    if (parts.length == 4)
                        afegeixProducte(new Producte(Integer.parseInt(parts[0]),parts[1],Double.parseDouble(parts[2]),Categoria.valueOf(parts[3])));
                }
            }
        //} catch (IOException | NumberFormatException | IllegalArgumentException e) {
        } catch (Exception e) {
            System.err.println("Error carregant productes: " + e.getMessage());
        }
    }
    
    public void carregaProductesTaula(String taula) { 
        
    }

    public void afegeixProducte(Producte producte) {
        if (productes.indexOf(producte.getId()) == -1 )
            productes.add(producte);
    }
    


    public void desaClientsACSV(String path) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))) {
            for (Client c : clients.values()) {
                bw.write(c.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error desant clients: " + e.getMessage());
        }
    }



    public void desaProductesACSV(String path) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))) {
            for (Producte p : productes.values()) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error desant productes: " + e.getMessage());
        }
    }

    // --- REGISTRE I CONSULTA DE VENDES ---
    public void registrarVenda(int idVenda, int idClient, List<Integer> idsProductes, LocalDate data) {
        Client client = clients.get(idClient);
        if (client == null) {
            System.err.println("Client no trobat.");
            return;
        }
        List<Producte> llista = new ArrayList<>();
        for (int id : idsProductes) {
            Producte p = productes.get(id);
            if (p != null) llista.add(p);
            else System.err.println("Producte amb ID " + id + " no trobat.");
        }
        if (!llista.isEmpty()) {
            Venda venda = new Venda(idVenda, client, llista, data);
            vendes.add(venda);
            desaVendaAMySQL(venda);
        }
    }

    public void mostrarHistorialVendes() {
        if (vendes.isEmpty()) {
            System.out.println("No hi ha cap venda registrada.");
        } else {
            for (Venda v : vendes) {
                System.out.println(v);
            }
        }
    }

    // --- PERSISTÈNCIA A MYSQL ---
    public void desaClientAMySQL(Client client) {
        String sql = "INSERT INTO clients (id, nom, email) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, client.getId());
            stmt.setString(2, client.getNom());
            stmt.setString(3, client.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserint client a MySQL: " + client.toString() + ": " + e.getMessage());
        }
    }

    public void desaProducteAMySQL(Producte producte) {
        String sql = "INSERT INTO productes (id, nom, preu, categoria) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, producte.getId());
            stmt.setString(2, producte.getNom());
            stmt.setDouble(3, producte.getPreu());
            stmt.setString(4, producte.getCategoria().toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserint producte a MySQL: " + producte.toString() + ": " + e.getMessage());
        }
    }

    public void desaVendaAMySQL(Venda venda) {
        String insertVenda = "INSERT INTO vendes (id, client_id, data) VALUES (?, ?, ?)";
        String insertVP = "INSERT INTO venda_producte (venda_id, producte_id) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya)) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmtVenda = conn.prepareStatement(insertVenda);
                 PreparedStatement stmtVP = conn.prepareStatement(insertVP)) {

                stmtVenda.setInt(1, venda.getIdVenda());
                stmtVenda.setInt(2, venda.getClient().getId());
                stmtVenda.setDate(3, Date.valueOf(venda.getDataVenda()));
                stmtVenda.executeUpdate();

                for (Producte p : venda.getProductes()) {
                    stmtVP.setInt(1, venda.getIdVenda());
                    stmtVP.setInt(2, p.getId());
                    stmtVP.addBatch();
                }
                stmtVP.executeBatch();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("Error inserint venda a MySQL: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Error connexió MySQL: " + e.getMessage());
        }
    }
}