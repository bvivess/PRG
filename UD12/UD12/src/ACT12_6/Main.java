package ACT12_6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Dades de la connexió:
        String servidor = "jdbc:mysql://localhost:3306/";
        String bdades = "gbd";
        String usuari = "root";
        String passwd = "";
        String sql = """
                     INSERT INTO departments(department_id, department_name, manager_id, location_id)
                     VALUES (?,?,?,?)""";
      
        // Establir la connexió
        try ( Connection connexio = DriverManager.getConnection(servidor+bdades, usuari, passwd);
              PreparedStatement stmt = connexio.prepareStatement(sql) ) {
            int departmentId = 401;  // simulant la lectura de l'arxiu
            String departmentName = "prova";
            int managerId = 100;
            int locationId = 1000;
            
            System.out.println("Connexió amb la base de dades MySQL exitosa.");
            
            stmt.setInt(1, departmentId);
            stmt.setString(2, departmentName);
            stmt.setInt(3, managerId);
            stmt.setInt(4, locationId);
            int filasAfectades = stmt.executeUpdate();
            
            // Procesar el resultado de la ejecución
            if (filasAfectades > 0) {
                System.out.println("Inserció en la base de dades MySQL exitosa." + " " + filasAfectades);
            } else {
                System.out.println("Inserció en la base de dades MySQL fallida.");
            }

            System.out.println("Connexió tancada.");
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de dades: " + e.getMessage());
        }
    }
}