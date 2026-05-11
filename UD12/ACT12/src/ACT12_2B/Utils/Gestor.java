package ACT12_2B.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class Gestor {
    public void desaUsuaris(GestorBBDD gestorBBDD, Map<Integer, String> usuaris) {
        try ( Connection conn = gestorBBDD.getConnectionFromFile() ) {
            usuaris.entrySet()
                 .stream()
                 .forEach( tupla -> { try { 
                                            gestorBBDD.executaSQL(conn, 
                                                                  """
                                                                  INSERT INTO usuaris (id, nom) 
                                                                  VALUES (?, ?)
                                                                  """,
                                                                  tupla.getKey(), tupla.getValue());
                                         } catch (SQLException e) {
                                             try {
                                                if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062)
                                                    gestorBBDD.executaSQL( conn, 
                                                                           """
                                                                           UPDATE usuaris 
                                                                           SET nom = ? 
                                                                           WHERE id = ?
                                                                           """,
                                                                           tupla.getValue(), tupla.getKey() );
                                                else 
                                                    throw new RuntimeException (e);  // en un 'forEach' cal disparar aquesta exception
                                             } catch (SQLException e2) {
                                                 throw new RuntimeException (e2);  // en un 'forEach' cal disparar aquesta exception
                                             }
                                         }
                                     }
                         );

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
