package EXAMEN;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;
import java.util.Arrays;

public class EX_3 { 
    static int NTAULER;
    static int NTORRES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_MATAT = 1;
    static final int SIMBOL_TORRE = 9;
    static int[][] tauler;
    static ArrayList<int[]> torres = new ArrayList<>(); // posició (x,y) de cada torre

    public static void main(String[] args) {
        NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NTORRES = UtilitatsConsola.llegirSencer("Nombre de torres a generar: ");
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        
        
        // Generar les torres i mostrar-les
        torres = generaTorres();
        mostraTorres(torres);
        
        // TO-DO
        emplenaTauler(tauler, torres);
        comprovaTorres(torres);

        // Mostrar la matriu amb la puntuació 
        UtilitatsMatrius.mostrarMatriu(tauler);
    }
    
    private static void emplenaTauler(int[][] tauler, ArrayList<int[]> torres) {
        // ha de situar cada torre en el tauler ? SIMBOL_REINA	
        // ha de indicar les caselles que cada torre mata ? SIMBOL_MATAT

    }
    
    private static void comprovaTorres(ArrayList<int[]> torres) {
        // per a cada torre, indicar quines de les altres la mata o no
 
    }  
    
    private static ArrayList<int[]> generaTorres() {
        ArrayList<int[]> torres = new ArrayList<>();
        int nTorres = 0;
        
        // Genera les N posicions de cada torre
        while (nTorres < NTORRES) {
            // Crea posició  
            boolean okTorre = true;
            int[] posTorre = UtilitatsArrays.generaArray(2,0, tauler.length-1); 
            
            // Comprova si ja existeix, posició a posició
            for (int j = 0; j < torres.size(); j++) {
                int[] torre = torres.get(j);
                
                if (Arrays.equals(torre, posTorre)) {
                    okTorre = false;
                    break;
                }
            }
            if (okTorre) {
                nTorres++;
                torres.add(posTorre);                
            }
        }
        
        return torres;
    }

    private static void mostraTorres(ArrayList<int[]> torres) {
        for (int[] torreXY : torres)
            UtilitatsArrays.mostraArray(torreXY);
    }
    
}
