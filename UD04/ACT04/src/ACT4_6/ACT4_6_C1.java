package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

public class ACT4_6_C1 { 
    static int NTAULER;
    static int NTORRES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_TORRE = 9;
    static final int SIMBOL_MATA = 1;
    static int[][] tauler;
    static int [] torre;

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NTORRES=UtilitatsConsola.llegirSencer("Nombre de torres: ");
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        int i = 0;

        while (i<=NTORRES) {
            afegeixTorre(tauler, torre);
            emplenaTauler(tauler, torre);
            mataTorre(tauler, torre);
        
        
            // mostrar el tauler
            
            i++;            
        }
    }
    
    public static void afegeixTorre(int[][] tauler, int[] torre) {
        // TODO code application logic here
        
    }
    
    public static void emplenaTauler(int[][] tauler, int[] torre) {
        // TODO code application logic here
        
    }
    
    public static void mataTorre(int[][] tauler, int [] torre) {
        // TODO code application logic here
        
    }
    
}
