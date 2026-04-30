package EX_3_2.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GestorBBDD {
    private final String MYSQL_CON;

    public GestorBBDD(String MYSQL_CON) {
        this.MYSQL_CON = MYSQL_CON;
    }
    
    public Connection getConnectionFromFile() throws SQLException, IOException {
        Map<String, String> valorsConnexio = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(this.MYSQL_CON))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                try {
                    if (!linia.substring(0, 1).equals("#")) {
                        String[] parts = linia.split("=");
                        String clau = parts[0].trim();
                        String valor = (parts[1] == null ? "" : parts[1].trim());  // cas de 'PASSWD = '
                    
                        switch (clau) {
                            case "SERVER", "DBASE", "USER", "PASSWD" -> valorsConnexio.put(clau, valor);
                            default -> System.err.println("Clau no vàlida en arxiu de connexió: " + clau);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    // Cas que l'split no funcioni
                    // No fer res
                }
            }
            if (!valorsConnexio.keySet().containsAll(Set.of("SERVER", "DBASE", "USER", "PASSWD")))
                throw new SQLException("L'arxiu no contempla totes les dades de connexió");
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection( valorsConnexio.get("SERVER") + valorsConnexio.get("DBASE"), 
                                            valorsConnexio.get("USER"), 
                                            valorsConnexio.get("PASSWD"));
    }
  
    // Executa SELECT, INSERT, DELETE, UPDATE
    public Object executaSQL(Connection conn, String sql, Object... arguments) throws SQLException {
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            assignaArguments(statement, arguments);
            
            if (sql.trim().toUpperCase().startsWith("SELECT"))
                return statement.executeQuery();
            else // INSERT, DELETE, UPDATE
                return statement.executeUpdate();
        } catch (SQLException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
    
    private void assignaArguments(PreparedStatement stmt, Object... arguments) throws SQLException {
        for (int i = 0; i < arguments.length; i++) {
            Object a = arguments[i];

            if (a == null) {
                stmt.setObject(i + 1, null);
            } else if (a instanceof Integer) {
                stmt.setInt(i + 1, (Integer) a);
            } else if (a instanceof Long) {
                stmt.setLong(i + 1, (Long) a);
            } else if (a instanceof Double) {
                stmt.setDouble(i + 1, (Double) a);
            } else if (a instanceof Float) {
                stmt.setFloat(i + 1, (Float) a);
            } else if (a instanceof Boolean) {
                stmt.setBoolean(i + 1, (Boolean) a);
            } else if (a instanceof LocalDate) {
                stmt.setDate(i + 1, Date.valueOf((LocalDate) a));
            } else if (a instanceof java.sql.Date) {
                stmt.setDate(i + 1, (java.sql.Date) a);
            } else if (a instanceof Timestamp) {
                stmt.setTimestamp(i + 1, (Timestamp) a);
            } else {
                stmt.setObject(i + 1, a);
            }
        }
    }
    
}
