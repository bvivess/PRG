package ACT11_4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Dades de la connexió:
        String servidor = "jdbc:mysql://localhost:3306/";
        String bdades = "gbd";
        String usuari = "root";
        String passwd = "";
        String sql = """
                     UPDATE departments
                     SET department_name = ?
                     WHERE department_id = ?
                     """;
      
        // Establir la connexió
        try ( Connection connexio = DriverManager.getConnection(servidor+bdades, usuari, passwd);
              PreparedStatement stmt = connexio.prepareStatement(sql) ) {
            int departmentId = 1000;  // simulant un Scanner
            String departmentName = "Prova update";
            
            System.out.println("Connexió amb la base de dades MySQL exitosa.");
            stmt.setString(1, departmentName);
            stmt.setInt(2, departmentId);
            
            if (stmt.executeUpdate()>=0)
                System.out.println("Modificació exitosa");
            else
                System.out.println("Inserció no exitosa");
            System.out.println("Connexió tancada.");
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de dades: " + e.getMessage());
        }
    }
}