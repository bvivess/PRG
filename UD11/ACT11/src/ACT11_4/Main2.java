package ACT11_4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Dades de la connexi�:
        String servidor = "jdbc:mysql://localhost:3306/";
        String bdades = "gbd";
        String usuari = "root";
        String passwd = "";
        String sql = """
                     SELECT department_id, department_name FROM departments WHERE department_id = 
                     """;
      
        // Establir la connexi�
        try ( Connection connexio = DriverManager.getConnection(servidor+bdades, usuari, passwd);
              Statement statement = connexio.createStatement() ) {
            int departmentId = 10;  // simulant un Scanner
            
            System.out.println("Connexi� amb la base de dades MySQL exitosa.");
            
            sql += departmentId;  // concatenaci� de la instrucci� SQL
            try (ResultSet resultSet = statement.executeQuery(sql)) {

                // Processar els resultats de la Query
                while (resultSet.next()) {
                    System.out.println( resultSet.getInt("department_id") + " " +
                                        resultSet.getString("department_name")
                                      );
                }
            } catch (SQLException e) {
                System.err.println("Error al executar la instrucci� SQL: " + e.getMessage());
            }
            System.out.println("Connexi� tancada.");
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de dades: " + e.getMessage());
        }
    }
}