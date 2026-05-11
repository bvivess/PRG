package ACT12_2B;

import ACT12_2B.Utils.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
        Gestor gestor = new Gestor();
    
        Map<Integer, String> usuaris = new HashMap<>();
        usuaris.put(1, "Anna"); usuaris.put(2,"Pere"); usuaris.put(3,"Joan");

        // Connexió a la base de dades
        try ( Connection conn = gestorBBDD.getConnectionFromFile() ) {
            gestor.desaUsuaris(gestorBBDD, usuaris);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
