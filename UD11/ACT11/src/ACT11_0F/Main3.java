package ACT11_0F;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main3 {
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
        try ( Connection connexio = DriverManager.getConnection(servidor+bdades, usuari, passwd);  // Establir connexió
              PreparedStatement stmt = connexio.prepareStatement(sql) ) {  // Prepara la instrucció
            int departmentId = 80;  // simulant un Scanner
            String departmentName = "Prova update";
            
            System.out.println("Connexió amb la base de dades MySQL exitosa.");
            stmt.setString(1, departmentName);
            stmt.setInt(2, departmentId);
            
            if (stmt.executeUpdate()>0)  // Executa SQL
                System.out.println("Modificació exitosa");

            System.out.println("Connexió tancada.");
        } catch (SQLException e) {
            System.err.println("Error en Base de dades: " + e.getMessage());
        }
    }
}