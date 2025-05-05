package ACT12_2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
    
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "Anna"); names.put(2,"Pere"); names.put(3,"Joan");

        // Connexió a la base de dades
        try ( Connection conn = gestorBBDD.getConnectionFromFile() ) {

            String sql = "INSERT INTO usuaris (id, nom) VALUES (?, ?)";

            names.entrySet().stream()
                .forEach( entry -> { 
                                    try {
                                        gestorBBDD.executaSQL(conn, sql, entry.getKey(), entry.getValue());
                                    } catch (SQLException e) {
                                        System.err.println(e.getMessage());
                                    }
                                 }
                        );


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
