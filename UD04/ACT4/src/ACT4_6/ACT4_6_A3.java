package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuaciÃ³ gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del cuc
  */

public class ACT4_6_A3 { 
    static int NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
    static int NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_FULLA = 99;  // cal modificar a 99 perquè el cuc pugui créixer
    static int SIMBOL_CUC = 1;  // 1,2,3 ... va creixent a mida que el cuc creix

    public static void main(String[] args) {
        int[][] tauler = UtilitatsMatrius.generaMatriu(NTAULER, 0, 0);  // matriu NTAULERxNTAULER
        int[] cuc = UtilitatsArrays.generaArray(2,0, tauler.length-1);     // (x,y) del cuc
        int accio;
        
        emplenaTauler(tauler, cuc);
        
        do {
            UtilitatsArrays.mostraArray(cuc);  //
            mostrarTauler(tauler);
            UtilitatsMatrius.mostraMatriu(tauler);
            accio = UtilitatsConsola.llegirSencer("Puntuació: " + (float) SIMBOL_CUC +  " | 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            
            if (cambiaPosicio(tauler, cuc, accio)) {  // cuc es tropitja
                System.out.println("YOU LOSE");
                break;
            } else if (SIMBOL_CUC == NFULLES+1) {  // el nombre de segments del cuc és igual al nombre de fulles, NOTA: el cuc té 1 segment inicial
                System.out.println("YOU WIN"); 
                break;
            }
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
      
    public static boolean cambiaPosicio(int[][] tauler, int[] posicio, int accio) {
        switch (accio) {
            case 4 -> // ESQ
                posicio[1] = (posicio[1] == 0 ? NTAULER-1 : --posicio[1]); 
            case 6  -> // DRETA
                posicio[1] = (posicio[1] == NTAULER-1 ? 0 : ++posicio[1]); 
            case 8  -> // ALT
                posicio[0] = (posicio[0] == 0 ? NTAULER-1 : --posicio[0]); 
            case 2 -> //BAIX
                posicio[0] = (posicio[0] == NTAULER-1 ? 0 : ++posicio[0]); 
        }
        // re-escriure el cuc
        if ((tauler[posicio[0]][posicio[1]]) == SIMBOL_FULLA) {  // cuc menja fulla
            SIMBOL_CUC++;
            tauler[posicio[0]][posicio[1]] = SIMBOL_CUC;
            
            //afegeixFulla(tauler); // nova fulla
        } else if ((tauler[posicio[0]][posicio[1]]) == SIMBOL_BUIT) {  // cuc es mou
            for (int i=0; i<NTAULER; i++) {
                for (int j=0; j<NTAULER; j++) {
                    if ((tauler[i][j] > SIMBOL_BUIT) & (tauler[i][j] < SIMBOL_FULLA)) {
                        tauler[i][j] = tauler[i][j] - 1;
                    }
                }
            }
            tauler[posicio[0]][posicio[1]] = SIMBOL_CUC;
        } else {                                                // cuc es tropitja
            //SIMBOL_CUC = SIMBOL_BUIT-1;                         // tornam -1 --> fi de la partida !!!
            return true;
        }
        return false;
    }
 
    public static void mostrarTauler(int[][] tauler) {
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
