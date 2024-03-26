package ACT12_0F;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Dades de la connexió:
        String servidor = "jdbc:mysql://localhost:3306/";
        String bdades = "gbd";
        String usuario = "root";
        String passwd = "";

        // Establecer la conexión
        try ( Connection conexion = DriverManager.getConnection(servidor+bdades, usuario, passwd);
              Statement statement = conexion.createStatement();
              ResultSet resultSet = statement.executeQuery("SELECT employee_id, last_name, first_name FROM employees")) {

            System.out.println("Connexió amb la base de dades MySQL exitosa.");
            
            // Processar els resultats de la Query
            System.out.println("ID\tLlinatge i nom");
            while (resultSet.next()) {
                System.out.println( resultSet.getInt("employee_id") + "\t" + 
                                    resultSet.getString("last_name") + ", " + 
                                    resultSet.getString("first_name")
                                  );
            }

            System.out.println("Conexió tancada.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}


    
        
           