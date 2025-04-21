package ACT11_6B.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class UtilBBDD {
    final String MYSQL_CON = "c:\\temp\\mysql.con";
    
    protected Connection getConnectionFromFile(String filename) throws SQLException, IOException {
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
                            default -> System.err.println("Clau no vàlida en arxiu de connexió: " + clau);
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
    
    public ResultSet executaQuerySQL(Connection connexio, String sql, Object... arguments) throws SQLException, IOException {
        try { 
            PreparedStatement stmt = connexio.prepareStatement(sql);
            
            for (int i = 0; i < arguments.length; i++) {
                Object arg = arguments[i];
                
                if (arg == null) {
                    stmt.setObject(i + 1, null);
                } else if (arg instanceof Integer) {
                    stmt.setInt(i + 1, (Integer) arg);
                } else if (arg instanceof Double) {
                    stmt.setDouble(i + 1, (Double) arg);
                } else if (arg instanceof Boolean) {
                    stmt.setBoolean(i + 1, (Boolean) arg);
                } else if (arg instanceof java.time.LocalDate) {
                    stmt.setDate(i + 1, java.sql.Date.valueOf((java.time.LocalDate) arg));
                } else if (arg instanceof java.sql.Date) {
                    stmt.setDate(i + 1, (java.sql.Date) arg);
                } else {
                    stmt.setObject(i + 1, arg); // per defecte, assumeix que és un tipus compatible
                }
            }
            return stmt.executeQuery(); // Retorna el ResultSet
         } catch (SQLException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
            //return null;
        }           
    }
    
    public void executaSQL(Connection connexio, String sql, Object... arguments) throws SQLException, IOException {
        try { 
            PreparedStatement stmt = connexio.prepareStatement(sql);

            for (int i = 0; i < arguments.length; i++) {
                Object arg = arguments[i];
                
                if (arg == null) {
                    stmt.setObject(i + 1, null);
                } else if (arg instanceof Integer) {
                    stmt.setInt(i + 1, (Integer) arg);
                } else if (arg instanceof Double) {
                    stmt.setDouble(i + 1, (Double) arg);
                } else if (arg instanceof Boolean) {
                    stmt.setBoolean(i + 1, (Boolean) arg);
                } else if (arg instanceof java.time.LocalDate) {
                    stmt.setDate(i + 1, java.sql.Date.valueOf((java.time.LocalDate) arg));
                } else if (arg instanceof java.sql.Date) {
                    stmt.setDate(i + 1, (java.sql.Date) arg);
                } else {
                    stmt.setObject(i + 1, arg); // per defecte, assumeix que és un tipus compatible
                }
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
            //return -1;
        }
    }
    
}
