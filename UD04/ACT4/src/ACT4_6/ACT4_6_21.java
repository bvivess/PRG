package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;
import java.util.Arrays;

public class ACT4_6_21 { 
    static int NTAULER;
    static int NREINES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_REINA = 9;
    static int[][] tauler;
    static ArrayList<int[]> reines = new ArrayList<>();

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NREINES=UtilitatsConsola.llegirSencer("Nombre de reines a generar: ");
        tauler = new int[NTAULER][NTAULER];  // matriu matriu NTAULERxNTAULER
        
        reines = generaReines();
        mostraReines(reines);
        
        // TO-DO
        
    }
    
    public static ArrayList<int[]> generaReines() {
        ArrayList<int[]> reines = new ArrayList<>();
        int nReines = 0;
        
        // Genera les N posicions de cada reina
        while (nReines < NREINES) {
            // Crea posició  
            boolean okReina = true;
            int[] posReina = UtilitatsArrays.generaArray(2,0, tauler.length-1); 
            
            // Comprova si ja existeix, posició a posició
            for (int j = 0; j < reines.size(); j++) {
                int[] reina = reines.get(j);
                
                if (Arrays.equals(reina, posReina)) {
                    okReina = false;
                    break;
                }
            }
            if (okReina) {
                nReines++;
                reines.add(posReina);                
            }

        }
        
        return reines;
    }

    private static void mostraReines(ArrayList<int[]> reines) {
        for (int[] reina : reines)
            UtilitatsArrays.mostraArray(reina);
    }
}
