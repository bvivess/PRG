package ACT12_0Z;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        UtilBBDD gestorBBDD = new UtilBBDD(MYSQL_CON);
    
        List<String> noms = List.of("Anna", "Joan", "Maria");

        // Connexió a la base de dades
        try ( Connection conn = gestorBBDD.getConnectionFromFile() ) {

            String sql = "INSERT INTO usuaris (nom) VALUES (?)";

            try ( PreparedStatement stmt = conn.prepareStatement(sql) ) {
                noms.stream()
                    .forEach( nom -> { 
                                        try {
                                            //stmt.setString(1, nom);
                                            //stmt.executeUpdate();
                                            gestorBBDD.executaQuerySQL(conn, sql, nom);
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                     }
                            );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
