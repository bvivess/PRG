package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 5x5:
  *      Mostra-la per pantalla, cada fila a una lÃ­nia.
  */
public class ACT4_6_A1 {
    static final int NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
    static int SIMBOL_BUIT = 0;
    static int SIMBOL_CUC = 1;
 
    public static void main(String[] args) {
        int[][] tauler = new int[NTAULER][NTAULER];  // tauler del joc
        int[] cuc = new int[2];  // posició {fila,columna} del cuc
        int accio; 

        // Emplena el tauler amb el cuc i les fulles
        emplenaTauler(tauler, cuc);
        
        do {
            // Mostra el tauler
            UtilitatsArrays.mostraArray(cuc);
            UtilitatsMatrius.mostraMatriu(tauler);
            
            // Cambia la posició del cuc
            accio=UtilitatsConsola.llegirSencer("ACCIONS: 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");     
            cambiaPosicio(tauler, cuc, accio);
        } while (accio!=0);
    }
    
    public static void emplenaTauler(int[][] tauler, int[] cuc) {
        // Generam una posició aleatòria pel cuc
        int[] pos = UtilitatsArrays.generaArray(2, 0, NTAULER-1);
        cuc[0] = pos[0];
        cuc[1] = pos[1];
        
        // Situa cuc en el tauler
        tauler[ cuc[0] ] [ cuc[1] ] = SIMBOL_CUC;
    }
    
    public static void cambiaPosicio(int[][] tauler, int[] cuc, int accio) {
        tauler[cuc[0]][cuc[1]] = SIMBOL_BUIT;
        switch (accio) {
            case 4 -> // ESQ
                cuc[1] = (cuc[1]==0 ? NTAULER-1 : --cuc[1]); 
            case 6  -> // DRETA
                cuc[1] = (cuc[1]==NTAULER-1 ? 0 : ++cuc[1]); 
            case 8  -> // ALT
                cuc[0] = (cuc[0]==0 ? NTAULER-1 : --cuc[0]); 
            case 2 -> //BAIX
                cuc[0] = (cuc[0]==NTAULER-1 ? 0 : ++cuc[0]); 
        }
        tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
    }
    
}