package EX_UD04;

import java.util.ArrayList;
import java.util.Arrays;

public class EX_3_OK { 
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
        
        // Emplenar i comprovar resultats
        emplenaTauler(tauler, torres);
        comprovaTorres(torres);

        // Mostrar la matriu amb la puntuació 
        UtilitatsMatrius.mostrarMatriu(tauler);
    }
    
    private static void emplenaTauler(int[][] tauler, ArrayList<int[]> torres) {
        // Per a cada 'torre' de 'torres':
        //     - ha de situar cada torre en el tauler ? SIMBOL_REINA	
        //     - ha de indicar les caselles que cada torre mata ? SIMBOL_MATAT
        
        // TO-DO code application logic here
        for (int[] torre : torres) {  // per a cada torre
            // situar la torre en el tauler
            tauler[torre[0]][torre[1]] = SIMBOL_TORRE;
            
            // indicar les caselles que es maten
            // files
            for (int i=0; i<tauler.length;i++)
                if (tauler[i][torre[1]]==SIMBOL_BUIT)
                    tauler[i][torre[1]] = SIMBOL_MATAT;
            // columnes
            for (int j=0; j<tauler.length;j++)
                if (tauler[torre[0]][j]==SIMBOL_BUIT)
                    tauler[torre[0]][j] = SIMBOL_MATAT;
        }
    }
    
    private static void comprovaTorres(ArrayList<int[]> torres) {
        // Per a cada torre, indicar quines de les altres la mata o no
        
        // TO-DO code application logic here
        boolean okTorre = true;
        
        for (int[] torre1:torres) { // compara cada torre amb la resta de torres, excepte ella mateixa
            okTorre = true;
            System.out.print("Comprovant " + torre1[0] + "-" + torre1[1] + " ") ;
            for (int[] torre2:torres)
                if (Arrays.compare(torre1, torre2) != 0) // <-- excepte ella mateixa
                    if (!(comprovaTorre(torre1, torre2))) {
                        System.out.print("Torre KO amb " + torre2[0] + "-" + torre2[1] + " ");
                        okTorre = false;
                    }
            if (okTorre)
                System.out.println("Torre OK ");
            else
                System.out.println("");
        }
        
    }  
    
    private static boolean comprovaTorre(int[] torre1, int[] torre2) {
        // si 'torre1' té fila o columna igual a 'torre2'
        if ((torre1[0] == torre2[0]) || (torre1[1] == torre2[1]))
            return false;
        else        
            return true;
    }
    
    private static ArrayList<int[]> generaTorres() {
        ArrayList<int[]> torres = new ArrayList<>();
        int nTorres = 0;
        
        // Genera les N posicions de cada torre
        while (nTorres < NTORRES) {
            // Crea posició  
            boolean okTorre = true;
            int[] torreProva = UtilitatsArrays.generaArray(2,0, tauler.length-1); 
            
            // Comprova si ja existeix, posició a posició
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
        // per a cada torre
        for (int[] torre : torres)
            UtilitatsArrays.mostraArray(torre);
    }
    
}
