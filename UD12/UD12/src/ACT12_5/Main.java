package ACT12_5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Establir la connexió
        try ( Connection connexio = getConnectionFromFile("c:\\temp\\mysql.con")  ) {
            System.out.println("Connexió establerta.");
 
            connexio.setAutoCommit(false);
            insertDepartmentsFromFile(connexio, "c:\\temp\\ACT12_5.txt");
            
            System.out.println("Connexió tancada.");
        } catch (Exception e) {
            System.err.println("S'ha produït l'error general: " + e.getMessage());
        }
    }
    
    private static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
        String servidor = "";
        String bdades = "";
        String usuari = "";
        String passwd = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split("=");
                    String clau = parts[0].trim();
                    String valor = parts[1].trim();
                    
                    switch (clau) {
                        case "SERVER" -> servidor = valor;
                        case "DBASE" -> bdades = valor;
                        case "USER" -> usuari = valor;
                        case "PASSWD" -> passwd = valor;
                        default -> System.err.println("Clau no vàlida: " + clau);
                    }
                } catch (IndexOutOfBoundsException e) {
                    // No fer res
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection(servidor + bdades, usuari, passwd);
    }
    
    private static void insertDepartmentsFromFile(Connection connexio, String filename) throws SQLException, IOException {
        String sql = "INSERT INTO departments (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?, ?, ?, ?)";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // Descartar la primera línia
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int departmentId = Integer.parseInt(parts[0]);
                String departmentName = parts[1];
                int managerId = Integer.parseInt(parts[2]);
                int locationId = Integer.parseInt(parts[3]);

                try (PreparedStatement statement = connexio.prepareStatement(sql)) {
                    statement.setInt(1, departmentId);
                    statement.setString(2, departmentName);
                    statement.setInt(3, managerId);
                    statement.setInt(4, locationId);
                    statement.executeUpdate();
                    System.out.println("Insertant departament: " + departmentId);
                    
                    connexio.commit();
                } catch (SQLException e) {
                    connexio.rollback();
                    System.err.println("Error executant la instrucció SQL: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e; // Es propaga l'excepció al mètode anterior
        }
    }
}