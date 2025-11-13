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

public class ACT4_6_A2 {
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_CUC = 1;
    static final int SIMBOL_FULLA = 9;
    static final int NTAULER = UtilitatsConsola.llegirSencer("Introdueixi la mida del tauler: ");
    static final int NFULLES = UtilitatsConsola.llegirSencer("Numero de fulles: ");
    
    public static void main(String[] args) {
        int[][] tauler = new int[NTAULER][NTAULER];  // tauler del joc
        int[] cuc = new int [2]; // posició {fila,columna} del cuc
        int accio;
        
        // Emplena el tauler amb el cuc i les fulles
        emplenaTauler(tauler, cuc);
        
        do {
            // Mostra el tauler
            UtilitatsArrays.mostraArray(cuc);
            UtilitatsMatrius.mostrarMatriu(tauler);
            
            // Cambia la posició del cuc
            accio = UtilitatsConsola.llegirSencer("ACCIONS: 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            cambiaPosicio(tauler,cuc,accio);
        } while (accio != 0);
    }
    
    public static void emplenaTauler(int[][] tauler, int[] cuc) {
        int[] fulla;
        1
        // Situam el cuc:
        cuc = UtilitatsArrays.generaArray(2, 0, NTAULER-1); 
        tauler [cuc[0]] [cuc[1]] = SIMBOL_CUC;
        
        // Situam les fulles:
        int nfulles = 0;
        while (nfulles <= NFULLES) {
            // Generam una posició aleatòria per a una fulla
            fulla = UtilitatsArrays.generaArray(2, 0, NTAULER-1);
            if (tauler[fulla[0]][fulla[1]] == SIMBOL_BUIT) {
              tauler[fulla[0]][fulla[1]] = SIMBOL_FULLA;
              nfulles++;
            }
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