package ACT11_0E;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {
    public static void main(String[] args) {
        // Dades de la connexió:
        String servidor = "jdbc:mysql://localhost:3306/";
        String bdades = "gbd";
        String usuari = "root";
        String passwd = "";
        String sql = "SELECT employee_id, last_name, first_name FROM employees";

        // Establir la connexió
        try ( Connection connexio = DriverManager.getConnection(servidor+bdades, usuari, passwd);  // Estableix la connexió amb la base de dades
              Statement statement = connexio.createStatement();  // Crea un objecte per executar una instrucció SQL
              ResultSet resultSet = statement.executeQuery(sql) ) {  // Executa una consulta (SELECT) i retorna els resultats

            System.out.println("Connexió amb la base de dades MySQL exitosa.");
            
            // Processar els resultats de la Query
            System.out.println("ID\tLlinatge, nom");
            while (resultSet.next()) {
                System.out.println( resultSet.getInt("employee_id") + "\t" + 
                                    resultSet.getString("last_name") + ", " + 
                                    resultSet.getString("first_name")
                                  );
            }

            System.out.println("Connexió tancada.");
        } catch (SQLException e) {
            System.err.println("Error en Base de dades: " + e.getMessage());
        }
    }
}