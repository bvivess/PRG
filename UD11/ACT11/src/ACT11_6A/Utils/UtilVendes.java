package ACT11_6A.Utils;

import ACT11_6A.Classes.Producte;
import ACT11_6A.Classes.*;
import java.sql.Statement;
import java.sql.ResultSet;
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
import java.util.NoSuchElementException;

public class UtilVendes {
    List<Client> clients = new ArrayList<>();
    List<Producte> productes = new ArrayList<>();
    Map<Integer,Venda> vendes = new HashMap<>();
    
    // --- ALTA DE CLIENTS 
    public void carregaClients(String path) throws SQLException, IOException {
        carregaClientsCSV(this.clients, path);
        carregaClientsBBDD(this.clients);
    }

    public void carregaClientsCSV(List<Client> clients, String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.substring(0, 1).equals("#")) {
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
    
    public void carregaClientsBBDD(List<Client> clients) throws SQLException, IOException{ 
        UtilBBDD gestorBBDD = new UtilBBDD();
        
        String sql = "SELECT id, nom, email FROM clients";
        try ( Connection connexio = gestorBBDD.getConnectionFromFile("c:\\temp\\mysql.con");
              Statement statement = connexio.createStatement();
              ResultSet resultSet = statement.executeQuery(sql) ) {
            while (resultSet.next())
                afegeixClient( clients, new Client( resultSet.getInt("id"),
                                                    resultSet.getString("nom"), 
                                                    resultSet.getString("email") )
                             );
        } catch (SQLException e) {
            System.err.println("Error carregant clients BBDD: " + e.getMessage());
        }
    }
    
    public void afegeixClient(List<Client> clients, Client client) {
        if (clients.indexOf(client.getId()) == -1 )
            clients.add(client);
    }
    
    // --- ALTA PRODUCTES
    public void carregaProductes(String path) throws SQLException, IOException {
        carregaProductesCSV(this.productes, path);
        carregaProductesBBDD(this.productes);
    }
    
    public void carregaProductesCSV(List<Producte> productes, String path) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.substring(0, 1).equals("#")) {
                    String[] parts = linia.split(",");
                    if (parts.length == 4)
                        afegeixProducte(productes, new Producte( Integer.parseInt(parts[0]),
                                                                 parts[1],
                                                                 Double.parseDouble(parts[2]),
                                                                 Categoria.valueOf(parts[3])) );
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant productes: " + e.getMessage());
        }
    }
    
    public void carregaProductesBBDD(List<Producte> productes) throws SQLException, IOException{ 
        UtilBBDD gestorBBDD = new UtilBBDD();
        
        String sql = "SELECT id, nom, preu, categoria FROM clients";
        try ( Connection connexio = gestorBBDD.getConnectionFromFile("c:\\temp\\mysql.con");
              Statement statement = connexio.createStatement();
              ResultSet resultSet = statement.executeQuery(sql) ) {
            while (resultSet.next())
                afegeixProducte( productes, new Producte( resultSet.getInt("id"),
                                                          resultSet.getString("nom"), 
                                                          resultSet.getDouble("preu"),
                                                          Categoria.valueOf(resultSet.getString("categoria").toUpperCase()) )
                             );
        } catch (SQLException e) {
            System.err.println("Error carregant clients BBDD: " + e.getMessage());
        }
    }

    public void afegeixProducte(List<Producte> productes, Producte producte) {
        if (productes.indexOf(producte.getId()) == -1 )
            productes.add(producte);
    }
    
    // --- ALTA DE VENDES 
    public void carregaVendes(String path) throws SQLException, IOException {
        carregaVendesCSV(this.vendes, path);
        //carregaVendesBBDD(clients, "CLIENTS");
    }

    public void carregaVendesCSV(Map<Integer,Venda> vendes, String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.substring(0, 1).equals("#")) {
                    String[] parts = linia.split(",");
                    if (parts.length == 4) {
                        // Processar els productes separats per ;
                        Venda venda = new Venda( Integer.parseInt(parts[0]),
                                                 LocalDate.parse(parts[1]),
                                                 cercaClient( new Client(Integer.parseInt(parts[2]), null, null) ), // 'client' temporal
                                                 new ArrayList<>() );
                        String[] producteIds = parts[3].split(";");

                        for (String pId : producteIds) {
                            if (!pId.trim().isEmpty()) {
                                venda.getProductes().add( cercaProducte( new Producte(Integer.parseInt(pId.trim()), null, 0.0, null) ) );
                            }
                        }
                        
                        afegeixVenda(this.vendes, venda );
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant clients CVS: " + e.getMessage());
        }
    }
    
    public void carregaVendesBBDD(Map<Integer,Venda> vendes) throws SQLException, IOException{ 
        UtilBBDD gestorBBDD = new UtilBBDD();
        
        String sql = "SELECT id, client_id, data, producte_id FROM vendes, venda_producte where id = venda_id";
        try ( Connection connexio = gestorBBDD.getConnectionFromFile("c:\\temp\\mysql.con");
              Statement statement = connexio.createStatement();
              ResultSet resultSet = statement.executeQuery(sql) ) {
            Venda venda=null;
            while (resultSet.next()) {
                venda = vendes.get(resultSet.getInt("id"));
                if ( venda == null)
                    venda = new Venda(  resultSet.getInt("id"),
                                        resultSet.getDate("data").toLocalDate(),
                                        cercaClient( new Client(resultSet.getInt("client_id"), null, null) ),
                                        new ArrayList<>() ); 
                
                venda.getProductes().add( cercaProducte( new Producte(resultSet.getInt("producte_id"), null, 0.0, null) ) );
                    
            }
            afegeixVenda(vendes, venda);
                                                  
        } catch (SQLException e) {
            System.err.println("Error carregant clients BBDD: " + e.getMessage());
        }
    }

    public void afegeixVenda(Map<Integer,Venda> vendes, Venda venda) {
        if (vendes.get(venda.getId()) == null )
            vendes.put(venda.getId(), venda);
    }
    
    private Client cercaClient (Client c) throws NoSuchElementException {
        for (Client client : this.clients) 
            if (c.equals(client))
                return client;
        
        throw new NoSuchElementException("Client no trobat a la llista.");
    }
    
    private Producte cercaProducte (Producte p) throws NoSuchElementException {
        for (Producte producte : this.productes) 
            if (p.equals(producte))
                return producte;
        
        throw new NoSuchElementException("Producte no trobat a la llista.");
    }
   


    
}