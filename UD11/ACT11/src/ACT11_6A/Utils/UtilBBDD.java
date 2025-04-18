package ACT11_6A.Utils;

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
    
    protected static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
        Map<String, String> valorsConnexio = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                try {
                    if (!linia.substring(0, 1).equals("#")) {
                        String[] parts = linia.split("=");
                        String clau = parts[0].trim();
                        String valor = parts[1].trim();
                    
                        switch (clau) {
                            case "SERVER" -> valorsConnexio.put( "SERVER", valor);
                            case "DBASE" -> valorsConnexio.put( "DBASE", valor);
                            case "USER" -> valorsConnexio.put( "USER", valor);
                            case "PASSWD" -> valorsConnexio.put( "PASSWD", valor);
                            default -> System.err.println("Clau no vàlida: " + clau);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    // Cas que l'split no fncioni
                    // No fer res
                }
            }
            if (valorsConnexio.size() != 4)
                throw new SQLException("L'arxiu no contemple totes les dades de connexió");
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection( valorsConnexio.get("SERVER") + valorsConnexio.get("DBASE"), 
                                            valorsConnexio.get("USER"), 
                                            valorsConnexio.get("PASSWD"));
    }
}
