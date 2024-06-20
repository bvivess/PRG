package EX_RECUPERACIO_13B;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        try {
            baseDadesAObjectes("c:\\temp\\dbase.con\\", customers);
            mostrarObjectes(customers);
            objectesAArxiu("c:\\temp\\customers.txt", customers);
        } catch (IOException | SQLException e) {
            System.out.println("Exception: " + e);
        }
    }
    
    private static void baseDadesAObjectes(String nomArxiu, List<Customer> customers) throws SQLException, IOException  {
        String sql="""
                    SELECT customer_id, cust_first_name, cust_last_name
                    FROM customers c
                    ORDER BY customer_id 
                   """;
        try ( Connection connexio = connectaDB(nomArxiu);
              Statement statement = connexio.createStatement();
              ResultSet resultSet = statement.executeQuery(sql) ) {
            System.out.println("Connexió establerta.");
            while (resultSet.next()) {
                List<Order> orders = new ArrayList<>();
                
                ordersAObjectes(nomArxiu, resultSet.getInt("customer_id"), orders);
                
                Customer customer = new Customer( resultSet.getInt("customer_id"),
                                                   resultSet.getString("cust_first_name"),
                                                    resultSet.getString("cust_last_name"),
                                                           orders);
                customers.add(customer);
            }
            
            System.out.println("Connexió tancada.");
        } catch (SQLException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
    
    private static void ordersAObjectes(String nomArxiu, int customerId, List<Order> orders) throws SQLException, IOException  {
        String sql="""
                    SELECT order_id, customer_id, DATE_FORMAT(order_date, '%d-%m-%Y') order_date, order_mode, order_total
                    FROM orders o
                    WHERE customer_id = """ + customerId + """
                    ORDER BY order_id
                   """;
        try ( Connection connexio = connectaDB(nomArxiu);
              Statement statement = connexio.createStatement();
              ResultSet resultSet = statement.executeQuery(sql) ) {

            System.out.println("Connexió establerta.");
            while (resultSet.next()) {
                Order order = new Order(resultSet.getInt("order_id"),
                                     resultSet.getInt("customer_id"),
                                          LocalDate.parse(resultSet.getString("order_date"), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                                          resultSet.getString("order_mode"),
                                         resultSet.getDouble("order_total"));
                orders.add(order);
            }
            
            System.out.println("Connexió tancada.");
        } catch (SQLException e) {
            throw e;  // Es propaga l'excepció al mètode anterior

        }
    }
    
    private static Connection connectaDB(String filename) throws SQLException, IOException {
        String seccio = "";
        String server = "";
        String bdades = "";
        String usuari = "";
        String passwd = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("[server]"))
                    seccio = "server";
                else if (line.startsWith("[database]"))
                    seccio = "database";
                else if (line.startsWith("["))
                    seccio = "";
                else {
                    try {
                        String[] parts = line.split(":",2);
                        String clau = parts[0].trim();
                        String valor = parts[1].trim().replace("\"","");
                        
                        if (seccio.equals("server"))
                            switch (clau) {
                                case "name" -> server = valor;
                                default -> System.err.println("Clau no vàlida: " + clau);
                            }
                        else if (seccio.equals("database"))
                            switch (clau) {
                                case "name" -> bdades = valor;
                                case "user" -> usuari = valor;
                                case "password" -> passwd = valor;
                                default -> System.err.println("Clau no vàlida: " + clau);
                            }
                    } catch (IndexOutOfBoundsException e) {
                        // En cas de '#', l'split no funciona
                        // No fer res
                    }
                }
            }
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection(server + bdades, usuari, passwd);
    }
    
    private static void mostrarObjectes(List<Customer> customers) {
        for (Customer c : customers)
            System.out.println(c.toString());
    }

    private static void objectesAArxiu(String arxiu, List<Customer> customers) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arxiu))) {
            for (Customer c : customers) {
                writer.write(c.toString());
            }
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }

}
