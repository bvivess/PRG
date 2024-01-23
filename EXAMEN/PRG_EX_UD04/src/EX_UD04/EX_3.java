package EX_UD04;

import java.util.ArrayList;
import java.util.Arrays;

public class EX_3 { 
    static int NTAULER;
    static int NTORRES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_MATAT = 1;
    static final int SIMBOL_TORRE = 9;
    static int[][] tauler;
    static ArrayList<int[]> torres = new ArrayList<>(); // posicio (x,y) de cada torre

    public static void main(String[] args) {
        NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NTORRES = UtilitatsConsola.llegirSencer("Nombre de torres a generar: ");
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        
        
        // Generar les torres i mostrar-les
        torres = generaTorres();
        mostraTorres(torres);
        
        // Emplenar i comprovar resultats
        emplenaTauler(tauler, torres);
        comprovaTorres(torres);

        // Mostrar la matriu amb la puntuacio 
        UtilitatsMatrius.mostrarMatriu(tauler);
    }
    
    private static void emplenaTauler(int[][] tauler, ArrayList<int[]> torres) {
        // Per a cada 'torre' de 'torres':
        //     - ha de situar cada torre en el tauler ? SIMBOL_TORRE	
        //     - ha de indicar les caselles que cada torre mata ? SIMBOL_MATAT
        
        // TO-DO code application logic here

    }
    
    private static void comprovaTorres(ArrayList<int[]> torres) {
        // Per a cada torre, indicar quines de les altres la mata o no
        
        // TO-DO code application logic here
 
    }  
    
    private static ArrayList<int[]> generaTorres() {
        ArrayList<int[]> torres = new ArrayList<>();
        int nTorres = 0;
        
        // Genera les N posicions de cada torre
        while (nTorres < NTORRES) {
            // Crea posicio  
            boolean okTorre = true;
            int[] torreProva = UtilitatsArrays.generaArray(2,0, tauler.length-1); 
            
            // Comprova si ja existeix, posicio a posicio
            for (int j = 0; j < torres.size(); j++) {
                int[] torre = torres.get(j);
                
                if (Arrays.equals(torre, torreProva)) {
                    okTorre = false;
                    break;
                }
            }
            if (okTorre) {
                nTorres++;
                torres.add(torreProva);
            }
        }
        
        return torres;
    }

    private static void mostraTorres(ArrayList<int[]> torres) {
        for (int[] torre : torres)
            UtilitatsArrays.mostraArray(torre);
    }
    
}
