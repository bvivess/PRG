package ACT4_5;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 5x5:
  *      Mostra-la per pantalla, cada fila a una línia.
  */
public class ACT4_5_01 {
    static int SIMBOL_BUIT = 0;
    static int SIMBOL_FULLA = 1;
    static int SIMBOL_CUC = 9;
    static int[][] tauler;
    static int[] cuc; // x,y del cuc
    static int accio; // (x,y) de les fulles
    
    public static void main(String[] args) {
        final int NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        tauler = new int[NTAULER][NTAULER];
        cuc = new int[2];

        emplenaTauler(tauler,cuc);
        
        do {
            UtilitatsMatrius.mostrarMatriu(tauler);
            accio=UtilitatsConsola.llegirSencer("ACCIONS: 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            
            cambiarPosicio(tauler, cuc, accio);

        } while (accio!=0);
    }
    
    public static void emplenaTauler(int[][] tauler, int[] cuc) {
        final int minim = 0, maxim = tauler.length-1;
        // Genera posició cuc
        cuc[0]=(minim + (int) (Math.random() * (maxim - minim + 1)));
        cuc[1]=(minim + (int) (Math.random() * (maxim - minim + 1)));
        // Situa cuc en el tauler
        tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
    }
    
    public static void cambiarPosicio(int[][] tauler, int[] cuc, int car) {
        int mida = tauler.length;
        
        tauler[cuc[0]][cuc[1]] = SIMBOL_BUIT;
        switch (car) {
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