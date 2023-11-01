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
    static int[][] fulles;
    static int accio;
    
     public static void main(String[] args) {
        final int NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        final int NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        tauler = new int[NTAULER][NTAULER];  // matriu NFULLESxNFULLES
        cuc = new int[2];                    // array[2]--> (x,y)
        fulles = new int[NFULLES][2];        // array[NFULLES][2] --> (x,y) de cada fulla

        emplenaTauler(tauler, cuc, fulles);
        
        do {
            UtilitatsMatrius.mostrarMatriu(tauler);
            accio=UtilitatsConsola.llegirSencer("ACCIONS: 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            
            cambiarPosicio(tauler, cuc, accio);

        } while (accio!=0);
    }
     
    public static void emplenaTauler(int[][] tauler, int[] cuc, int[][] fulles) {
        final int minim = 0, maxim = tauler.length-1;
        
        // Genera posició cuc
        cuc[0]=(minim + (int) (Math.random() * (maxim - minim + 1)));
        cuc[1]=(minim + (int) (Math.random() * (maxim - minim + 1)));
       
        // Genera posició fulles
        for (int i=0; i<fulles.length; i++) {
            fulles[i] = UtilitatsArrays.generaArray(2,0, tauler.length-1);
        }
        
        // Situa cuc i fulles en el tauler
        tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
        for (int i=0; i<fulles.length; i++) {
            tauler[ fulles[i][0]] [fulles[i][1] ] = SIMBOL_FULLA;
        }
    }
    
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
    
}