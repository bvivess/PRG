package EX_3_2;

import EX_3_2.Classes.*;
import EX_3_2.Utils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final String MYSQL_CON  = "c:\\temp\\mysql.con";
    private static final String CSV_PATH   = "c:\\temp\\Extra-vehicular_Activity_EVA_-_US_and_Russia_rows.csv";
    private static final String LOG_PATH   = "c:\\temp\\Extra-vehicular_Activity_EVA_-_US_and_Russia_rows.log";

    public static void main(String[] args) {
        int numLinies;
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
        GestorEVA gestorEVA = new GestorEVA();

        // Estructures de memòria

        try {
            // 1. CSV a estructures
            numLinies = gestorEVA.llegeixCSV(CSV_PATH, LOG_PATH);

            System.out.println("Resum de la lectura del CSV");
            System.out.println("Total línies carregades: " + numLinies);
            System.out.println("EVAs carregades  : " + gestorEVA.getEvas().size());
            System.out.println("Astronautes carregats: " + gestorEVA.getAstronauts().size());
            System.out.println();

            // 2. Mostrar estructures
            List<EVA> ordenades = new ArrayList<>(gestorEVA.getEvas().values());
            Collections.sort(ordenades);   // empra el 'compareTo()' d'EVA
            System.out.println(ordenades);

            // 3. Estructures a BD
            gestorEVA.estructuresABBDD(gestorBBDD);

        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }

}
