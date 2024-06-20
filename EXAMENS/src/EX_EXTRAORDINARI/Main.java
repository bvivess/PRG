package EX_EXTRAORDINARI;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Inventory> inventories = new ArrayList<>();
        try {
            llegirInventari("c:\\temp\\dbase.con\\", "c:\\temp\\inventory.txt\\", inventories);
            mostrarInventories(inventories);
        } catch (IOException | SQLException e) {
            System.out.println("Exception: " + e);
        }
    }
    
    private static void llegirInventari(String nomArxiu1, String nomArxiu2, List<Inventory> inventories) throws SQLException, FileNotFoundException, IOException{
        String text = "";
        
        try ( BufferedReader bufferInput = new BufferedReader(new FileReader(nomArxiu2));
              Connection connexio = connectaDB(nomArxiu1)
            ) {
            connexio.setAutoCommit(false);
            String linia = bufferInput.readLine();   // es rebuja la primera linia
            String sql = "";
            while ((linia = bufferInput.readLine()) != null) {
                String[] parts = linia.split(";");

                SQLExecute(connexio, inventories, parts);
            }

        } catch (FileNotFoundException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
    
    private static Connection connectaDB(String filename) throws SQLException, IOException {
        String driver = "";
        String server = "";
        String port = "";
        String bdades = "";
        String usuari = "";
        String passwd = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();  // es rebuja la primera linia
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":",2);
                String clau = parts[0].trim().replaceAll("[\\[\\]]", "");  // replace("[","").replace("]","");
                String valor = parts[1].trim().replace("\"","");

                switch (clau) {
                    case "driver" -> driver = valor;
                    case "server" -> server = valor;
                    case "port" -> port = valor;
                    case "database" -> bdades = valor;
                    case "user" -> usuari = valor;
                    case "password" -> passwd = valor;
                    default -> System.err.println("Clau no vàlida: " + clau);
                }
            }
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection(driver + "://" + server + ":" + port + "/" + bdades, usuari, passwd);
    }
    
    private static void SQLExecute(Connection connexio, List<Inventory> inventories, String[] parts) throws SQLException, IOException {
        Statement statement = connexio.createStatement();
        ResultSet resultSet;
        int product_id = Integer.valueOf(parts[0].trim());
        int warehouse_id = Integer.valueOf(parts[1].trim());
        double quantity_on_hand_old = Double.valueOf(parts[2].trim());
        
        String sql1 = """
                      SELECT product_id, warehouse_id, quantity_on_hand
                      FROM inventories i
                      WHERE product_id = """ + product_id + " " + """ 
                      AND   warehouse_id = """ + warehouse_id + " " + """ 
                      """;
        
        String sql2 = """
                      UPDATE inventories
                      SET quantity_on_hand = """ + parts[2].trim() + " " + """
                      WHERE product_id = """ + product_id + " " + """ 
                      AND   warehouse_id = """ + warehouse_id + " " + """ 
                      """;
        try {
            resultSet = statement.executeQuery(sql1);
            resultSet.next();
            double quantity_on_hand_new = resultSet.getDouble("quantity_on_hand");
            
            if (quantity_on_hand_new != quantity_on_hand_old) {
                inventories.add(new Inventory( product_id, warehouse_id, quantity_on_hand_old, quantity_on_hand_new ));
                statement.executeUpdate(sql2);
            }

            connexio.commit();
        } catch (SQLException e) {
            connexio.rollback();
            System.out.println("Error en SQL: " + e);
        }
    }
 
    private static void mostrarInventories (List<Inventory> inventories) {
        for (Inventory i : inventories) {
            System.out.println(i.toString());
        }
    } 
    
}
