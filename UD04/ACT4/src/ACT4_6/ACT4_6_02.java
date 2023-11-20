package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import ACT4_2.UtilitatsMatrius;


 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuaciÃ³ gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *
  */

public class ACT4_6_02 {
    static int NTAULER;
    static int NFULLES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_FULLA = 9;
    static final int SIMBOL_CUC = 1;
    static int[][] tauler;
    static int[] cuc;
    static int accio;
    
    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        tauler = UtilitatsMatrius.generaMatriu(NTAULER, 0, 0);  // matriu NTAULERxNTAULER
        cuc = UtilitatsArrays.generaArray(2,0, tauler.length-1);     // (x,y) del cuc
        
        emplenaTauler(tauler, cuc);
        
        do {
            UtilitatsMatrius.mostrarMatriu(tauler);
            accio=UtilitatsConsola.llegirSencer("ACCIONS: 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            
            cambiaPosicio(tauler, cuc, accio);

        } while (accio!=0);
    }
     
    public static void emplenaTauler(int[][] tauler, int[] cuc) {
        int[] fulla;
        
         // Situa el cuc en el tauler
        tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
        
        // Genera posició de cada fulla i situa en el tauler
        for (int i=0; i<NFULLES; i++) {
            // Genera posicions fulles
            fulla = UtilitatsArrays.generaArray(2,0, tauler.length-1);
            // Situa les fulles en el tauler
            tauler[fulla[0]] [fulla[1] ] = SIMBOL_FULLA;
        }
    }
    
    public static void cambiaPosicio(int[][] tauler, int[] cuc, int accio) {
        final int MIDA = tauler.length;
        
        tauler[cuc[0]][cuc[1]] = SIMBOL_BUIT;
        switch (accio) {
            case 4 -> // ESQ
                cuc[1] = (cuc[1]==0 ? MIDA-1 : cuc[1]-1); 
            case 6  -> // DRETA
                cuc[1] = (cuc[1]==MIDA-1 ? 0 : cuc[1]+1); 
            case 8  -> // ALT
                cuc[0] = (cuc[0]==0 ? MIDA-1 : cuc[0]-1); 
            case 2 -> //BAIX
                cuc[0] = (cuc[0]==MIDA-1 ? 0 : cuc[0]+1); 
        }
        tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
    }
    
}