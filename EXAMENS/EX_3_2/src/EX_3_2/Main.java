package EX_3_2;

import EX_3_2.Classes.*;
import EX_3_2.Utils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final String MYSQL_CON  = "c:\\temp\\mysql.con";
    private static final String CSV_PATH   = "c:\\temp\\Extra-vehicular_Activity_EVA_-_US_and_Russia_rows.csv";
    private static final String LOG_PATH   = "c:\\temp\\Extra-vehicular_Activity_EVA_-_US_and_Russia_rows.log";

    public static void main(String[] args) {
        int numLinies;
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
        GestorEVA gestorEVA = new GestorEVA();

        // Estructures de memòria
        Map<Integer, EVA> evas      = new HashMap<>();
        Set<Astronaut>    astronauts = new HashSet<>();
        try {
            // 1. CSV a estructures
            numLinies = gestorEVA.llegeixCSV(CSV_PATH, LOG_PATH, evas, astronauts);

            System.out.println("Resum de la lectura del CSV");
            System.out.println("Total línies carregades: " + numLinies);
            System.out.println("EVAs carregades  : " + evas.size());
            System.out.println("Astronautes carregats: " + astronauts.size());
            System.out.println();

            // 2. Mostrar estructures
            List<EVA> ordenades = new ArrayList<>(evas.values());
            Collections.sort(ordenades);   // usa el compareTo de EVA
            System.out.println(ordenades);

            // 3. Estructures a BD
            gestorEVA.estructuresABBDD(gestorBBDD, evas, astronauts);

        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }

}
