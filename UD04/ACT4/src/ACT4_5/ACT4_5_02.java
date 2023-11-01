package ACT4_5;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 5x5:
  *      Mostra-la per pantalla, cada fila a una línia.
  */
public class ACT4_5_02 {
    static int SIMBOL_BUIT = 0;
    static int SIMBOL_FULLA = 1;
    static int SIMBOL_CUC = 9;
    static int[][] tauler;
    static int[] cuc;
    static int accio;
    
    public static void cambiarPosicio(int[][] tauler, int[] cuc, int accio) {
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
    
    public static void main(String[] args) {
        final int MIDA=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        tauler = UtilitatsMatrius.generaMatriu(MIDA, SIMBOL_BUIT, SIMBOL_FULLA);
        cuc = UtilitatsArrays.generaArray(2,0,MIDA-1);  // situa el cuc en una coor. inicial

        tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
        UtilitatsArrays.mostraArray(cuc);
        
        do {
            UtilitatsMatrius.mostrarMatriu(tauler);
            accio=UtilitatsConsola.llegirSencer(" | 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            
            cambiarPosicio(tauler, cuc, accio);

        } while (accio!=0);
    }
}