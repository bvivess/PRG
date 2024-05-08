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
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de dades: " + e.getMessage());
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
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e; // Re-lanzar la excepción para manejarla en el método llamador si es necesario
        }

        // Establecer la conexión a la base de datos MySQL
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
                    System.out.println("Insertar departament: " + departmentId);
                    connexio.commit();
                } catch (SQLException e) {
                    connexio.rollback();
                    System.err.println("Error executant la instrucció SQL: " + e.getMessage());
                    //throw e; // Re-lanzar la excepción para manejarla en el método llamador si es necesario
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e; // Re-lanzar la excepción para manejarla en el método llamador si es necesario
        }
    }
}