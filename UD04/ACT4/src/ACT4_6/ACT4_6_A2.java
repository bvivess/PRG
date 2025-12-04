package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

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
        int[] cuc = new int[2];  // posició {fila,columna} del cuc
        int accio;
        
        // Emplena el tauler amb el cuc i les fulles
        emplenaTauler(tauler, cuc);
        
        do {
            // Mostra el tauler
            UtilitatsArrays.mostraArray(cuc);
            UtilitatsMatrius.mostraMatriu(tauler);
            mostraTauler(tauler);
            
            // Cambia la posició del cuc
            accio = UtilitatsConsola.llegirSencer("ACCIONS: 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            cambiaPosicio(tauler,cuc,accio);
        } while (accio != 0);
    }
    
    public static void emplenaTauler(int[][] tauler, int[] cuc) {
        // Generam una posició aleatòria pel cuc
        int[] pos = UtilitatsArrays.generaArray(2, 0, NTAULER-1);
        cuc[0] = pos[0];
        cuc[1] = pos[1];
        
        // Situa cuc en el tauler
        tauler[ cuc[0] ] [ cuc[1] ] = SIMBOL_CUC;
        
        // Situam les fulles:
        int nfulles = 0;
        while (nfulles < NFULLES) {
            // Generam una posició aleatòria per a una fulla
            pos = UtilitatsArrays.generaArray(2, 0, NTAULER-1);
            if (tauler[pos[0]][pos[1]] == SIMBOL_BUIT) {
              tauler[pos[0]][pos[1]] = SIMBOL_FULLA;
              nfulles++;
            }
        }
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
    
    public static void mostraTauler(int[][] tauler) {
        String car = "   ";
        for (int i = 0; i < NTAULER; i++) {
            System.out.print('|');
            for (int j = 0; j < NTAULER; j++) {
                if (tauler[i][j] == SIMBOL_BUIT) {
                    car = "   ";
                } else if (tauler[i][j] == SIMBOL_CUC) {
                    car = " O ";
                } else if (tauler[i][j] == SIMBOL_FULLA) {
                    car = " * ";
                } else if (tauler[i][j] > SIMBOL_BUIT && tauler[i][j] < SIMBOL_CUC) {
                    car = " . ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
    
}