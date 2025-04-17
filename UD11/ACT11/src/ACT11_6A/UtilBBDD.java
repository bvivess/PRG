package ACT11_6A;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
public class UtilBBDD {
  
    private static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
        Map<String, String> valors = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                try {
                    if (!linia.substring(0, 1).equals("#")) {
                        String[] parts = linia.split("=");
                        String clau = parts[0].trim();
                        String valor = parts[1].trim();
                    
                        switch (clau) {
                            case "SERVER" -> valors.put( "SERVER", valor);
                            case "DBASE" -> valors.put( "DBASE", valor);
                            case "USER" -> valors.put( "USER", valor);
                            case "PASSWD" -> valors.put( "PASSWD", valor);
                            default -> System.err.println("Clau no vàlida: " + clau);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    // Cas que l'split no fncioni
                    // No fer res
                }
            }
            if (valors.size() != 4)
                throw new SQLException("L'arxiu no contemple totes les dades de connexió");
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection( valors.get("SERVER") + valors.get("DBASE"), 
                                            valors.get("USER"), 
                                            valors.get("PASSWD"));
    }
}
