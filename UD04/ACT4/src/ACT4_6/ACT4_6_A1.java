package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 5x5:
  *      Mostra-la per pantalla, cada fila a una línia.
  */
public class ACT4_6_A1 {
    static int SIMBOL_BUIT = 0;
    static int SIMBOL_CUC = 1;
    static int[][] tauler;
    static int[] cuc; // x,y del cuc
    static int accio;  
    
    public static void main(String[] args) {
        final int NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
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
        // Situa cuc en el tauler
        tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
    }
    
    public static void cambiaPosicio(int[][] tauler, int[] cuc, int accio) {
        int mida = tauler.length;
        
        tauler[cuc[0]][cuc[1]] = SIMBOL_BUIT;
        switch (accio) {
            case 4 -> // ESQ
                cuc[1] = (cuc[1]==0 ? mida-1 : cuc[1]-1); 
            case 6  -> // DRETA
                cuc[1] = (cuc[1]==mida-1 ? 0 : cuc[1]+1); 
            case 8  -> // ALT
                cuc[0] = (cuc[0]==0 ? mida-1 : cuc[0]-1); 
            case 2 -> //BAIX
                cuc[0] = (cuc[0]==mida-1 ? 0 : cuc[0]+1); 
        }
        tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
    }
    
}