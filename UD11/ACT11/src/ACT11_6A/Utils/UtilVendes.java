package ACT11_6A.Utils;

import ACT11_6A.Categoria;
import ACT11_6A.Client;
import ACT11_6A.Producte;
import ACT11_6A.Venda;
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

public class UtilVendes {
    
    // --- ALTA DE CLIENTS 
    public void carregaClients(List<Client> clients, String path) throws SQLException, IOException {
        carregaClientsCSV(clients, path);
        carregaClientsBBDD(clients, "CLIENTS");
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
    
    public void carregaClientsBBDD(List<Client> clients, String taula) throws SQLException, IOException{ 
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
    public void carregaProductes(List<Producte> productes, String path) throws SQLException, IOException {
        carregaProductesCSV(productes, path);
        carregaProductesBBDD(productes);
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
    

}