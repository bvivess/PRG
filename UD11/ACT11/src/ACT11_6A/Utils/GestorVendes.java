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
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class GestorVendes {
    Set<Client> clients = new HashSet<>();
    Set<Producte> productes = new HashSet<>();
    Map<Integer,Venda> vendes = new HashMap<>();
    
    // --- C�RREGA CLIENTS 
    public void carregaClients(String path) throws SQLException, IOException {
        carregaClientsBBDD(this.clients);
        carregaClientsCSV(this.clients, path);

        System.out.println(this.clients);
    }
    
    public void carregaClientsBBDD(Set<Client> clients) throws SQLException, IOException{ 
        UtilBBDD gestorBBDD = new UtilBBDD();
        String sql = "SELECT id, nom, email FROM clients";
        try ( Connection connexio = gestorBBDD.getConnectionFromFile("c:\\temp\\mysql.con");
              Statement statement = connexio.createStatement();
              ResultSet resultSet = statement.executeQuery(sql) ) {
            
            while (resultSet.next()) {
                afegeixClient( clients, new Client( resultSet.getInt("id"),
                                                    resultSet.getString("nom"), 
                                                    resultSet.getString("email") )
                             );
            }
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
    
    // --- C�RREGA PRODUCTES
    public void carregaProductes(String path) throws SQLException, IOException {
        carregaProductesBBDD(this.productes);
        carregaProductesCSV(this.productes, path);
        
        System.out.println(this.productes);
        
    }
        
    public void carregaProductesBBDD(Set<Producte> productes) throws SQLException, IOException{ 
        UtilBBDD gestorBBDD = new UtilBBDD();
        
        String sql = "SELECT id, nom, preu, categoria FROM productes";
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
    
    public void carregaProductesCSV(Set<Producte> productes, String path) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!(linia.isEmpty() || linia.startsWith("#"))) {
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

    public void afegeixProducte(Set<Producte> productes, Producte producte) {
        productes.add(producte);
    }
    
    // --- C�RREGA VENDES 
    public void carregaVendes(String path) throws SQLException, IOException {
        carregaVendesBBDD(this.vendes);
        carregaVendesCSV(this.vendes, path);
        
        System.out.println(mostraVendes(this.vendes));
    }
  
    public void carregaVendesBBDD(Map<Integer,Venda> vendes) throws SQLException, IOException{ 
        UtilBBDD gestorBBDD = new UtilBBDD();
        
        String sql = "SELECT id, client_id, data, producte_id FROM vendes, venda_producte where id = venda_id";
        try ( Connection connexio = gestorBBDD.getConnectionFromFile("c:\\temp\\mysql.con");
              Statement statement = connexio.createStatement();
              ResultSet resultSet = statement.executeQuery(sql) ) {
            Venda venda = null;
            while (resultSet.next()) {
                venda = vendes.get(resultSet.getInt("id"));
                if ( venda == null) {
                    venda = new Venda(  resultSet.getInt("id"),
                                        resultSet.getDate("data").toLocalDate(),
                                        cercaClient( new Client(resultSet.getInt("client_id"), ".", ".") ),
                                        new ArrayList<>() ); 
                }
                venda.getProductes().add( cercaProducte( new Producte(resultSet.getInt("producte_id"), ".", 0.0, null) ) );
                afegeixVenda(vendes, venda);
            }
            
                                                  
        } catch (SQLException e) {
            System.err.println("Error carregant clients BBDD: " + e.getMessage());
        }
    }

    public void carregaVendesCSV(Map<Integer,Venda> vendes, String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!(linia.isEmpty() || linia.startsWith("#"))) {
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
  
    public void afegeixVenda(Map<Integer,Venda> vendes, Venda venda) {
        vendes.put(venda.getId(), venda);
    }
    
    public String mostraVendes(Map<Integer,Venda> vendes) {
        String text="Vendes: \n";
        for (Venda v : vendes.values()) {
            text += "\t" + v.toString() + "\n";
        }
        
        return text;
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
    
    // --- DESC�RREGA CLIENTS
    public void desaClients(String path) {
        desaClientsBBDD(this.clients);
        desaClientsCVS(this.clients, path);
    }
    
    private void desaClientsBBDD(Set<Client> clients) {
        
    }
    
    private void desaClientsCVS(Set<Client> clients, String path) {
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(path))) {
            for (Client c : clients) {
                br.write(c.getId() + "," + c.getNom() + "," + c.getEmail());
                br.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error descarregant clients CVS: " + e.getMessage());
        }
    }
    
    // --- DESC�RREGA PRODUCTES
    public void desaProductes(String path) {
        desaProductesBBDD(this.productes);
        desaProductesCVS(this.productes, path);
    }
    
    private void desaProductesBBDD(Set<Producte> productes) {
        
    }
    
    private void desaProductesCVS(Set<Producte> productes, String path) {
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(path))) {
            for (Producte p : productes) {
                br.write(p.getId() + "," + p.getNom() + "," + p.getPreu() + "," + p.getCategoria());
                br.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error descarregant clients CVS: " + e.getMessage());
        }
    }  
    
    // --- DESC�RREGA VENDES
    public void desaVendes(String path) {
        desaVendesBBDD(this.vendes);
        desaVendesCVS(this.vendes, path);
    }
    
    private void desaVendesBBDD(Map<Integer,Venda> vendes) {
        
    }
    
    private void desaVendesCVS(Map<Integer,Venda> vendes, String path) {
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(path))) {
            for (Venda v : vendes.values()) {
                String text = v.getId() + "," + v.getDataVenda() + "," + v.getClient().getId() + ",";
                for (Producte p : v.getProductes())
                    text += p.getId() + ";";
                br.write(text);
                br.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error descarregant clients CVS: " + e.getMessage());
        }
    }
}