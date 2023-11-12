package ACT4_5;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;
//import ACT4_2.UtilitatsMatrius;


 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuació gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del cuc
  */

public class ACT4_5_11 { 
    static int NTAULER;
    static int NMINES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_MINA = 9;
    static final int SIMBOL_DESACTIVAT = -1;
    static int[][] tauler;
    static ArrayList<int[]> mines = new ArrayList<>();
    static int posX,posY;

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NMINES=UtilitatsConsola.llegirSencer("Nombre de mines: ");
        tauler = new int[NTAULER][NTAULER];  // matriu matriu NTAULERxNTAULER

        emplenaTauler(tauler, mines);
        puntuarMines(tauler, mines);
        
        do {
            mostrarTauler(tauler);
            posX = UtilitatsConsola.llegirSencer("Posició X: ");
            posX = UtilitatsConsola.llegirSencer("Posició Y: ");
            

            
        } while (posY != 0);
    }
    
    public static void emplenaTauler(int[][] tauler, ArrayList<int[]> cuc) {
        final int MINIM = 0, MAXIM = tauler.length-1;
        int[] posMina;
        
        // Genera posició de cada fulla i situa en el tauler
        for (int i=0; i<NMINES; i++) {
            boolean okMina = true;
            do { // cerca una posisió buida per la fulla en el tauler
                posMina = UtilitatsArrays.generaArray(2,0, tauler.length-1);
                if (tauler[ posMina[0]] [posMina[1] ] == 0) { // situa la fulla al tauler si la posició està buida
                    tauler[ posMina[0]] [posMina[1] ] = SIMBOL_MINA;
                    okMina = false;
                    mines.add(posMina);
              }
            } while (okMina);
        }
    }
    
    public static void puntuarMines(int[][] tauler, ArrayList<int[]> mines) {
        int[] posMina = new int[2];
        
        System.out.println(mines.size());
        for (int m=0; m<mines.size();m++) {
            posMina = new int[] { mines.get(m)[0],
                                  mines.get(m)[1]
                                };
            //
            System.out.println(posMina[0]+"-"+posMina[1]);

            for (int i=Math.max(0, posMina[0]-1); i <= Math.min(tauler.length-1, posMina[0]+1); i++) {
                for (int j=Math.max(0, posMina[1]-1); j <= Math.min(tauler.length-1, posMina[1]+1); j++) {
                    System.out.println(i+"---"+j);
                    if (tauler[i][j]!=SIMBOL_MINA) {
                        tauler[i][j]++;
                    }
                }
            }
        }
    }
/*
    public static void afegeixFulla(int[][] tauler) {
        int mida = tauler.length;
        int[] fulla;
        boolean okfulla = true;
        
        do {
            fulla  = UtilitatsArrays.generaArray(2,0, mida-1); // genera posició de la fulla
            if (tauler[fulla[0]][fulla[1]] == 0) { // situa la fulla al tauler si la posició està buida
                tauler[fulla[0]][fulla[1]] = SIMBOL_FULLA;
                okfulla = false;
            }
        } while (okfulla);
        
    }
*/
    /*
    public static void cambiaPosicio(int[][] tauler, ArrayList<int[]> cuc, int accio) {
        int mida = tauler.length;
        int[] posCucCap = new int[] { cuc.get(cuc.size()-1)[0],
                                      cuc.get(cuc.size()-1)[1] };
        int[] posCucCua = new int[] { cuc.get(0)[0],
                                      cuc.get(0)[1]
                                    };
        tauler[posCucCap[0]][posCucCap[1]] = SIMBOL_CUC;
             
        switch (accio) {
            case 4 -> // ESQ
                posCucCap[1] = (posCucCap[1] == 0 ? mida-1 : posCucCap[1]-1); 
            case 6  -> // DRETA
                posCucCap[1] = (posCucCap[1] == mida-1 ? 0 : posCucCap[1]+1); 
            case 8  -> // ALT
                posCucCap[0] = (posCucCap[0] == 0 ? mida-1 : posCucCap[0]-1); 
            case 2 -> //BAIX
                posCucCap[0] = (posCucCap[0] == mida-1 ? 0 : posCucCap[0]+1); 
        }
        
        // re-escriure el cuc
        if ((tauler[posCucCap[0]][posCucCap[1]]) == SIMBOL_FULLA) {  // cuc menja fulla
            cuc.add(posCucCap); // afegim posCuc a cuc
            //SIMBOL_CUC++;
            tauler[posCucCap[0]][posCucCap[1]] = SIMBOL_CAPCUC;
            
            afegeixFulla(tauler); // nova fulla
        } else if ((tauler[posCucCap[0]][posCucCap[1]]) == SIMBOL_BUIT) {  // cuc es mou
            cuc.remove(0);
            cuc.add(posCucCap);
            tauler[posCucCap[0]][posCucCap[1]] = SIMBOL_CAPCUC;
            tauler[posCucCua[0]][posCucCua[1]] = SIMBOL_BUIT;
        } else {                                                // cuc es tropitja
            SIMBOL_CUC = SIMBOL_BUIT-1;                         // fi de la partida !!!
        }
    }
 */
    public static void mostrarTauler(int[][] matriu) {
        String car="";
        for (int i = 0; i < matriu.length; i++) {
            System.out.print('|');
            for (int j = 0; j < matriu[i].length; j++) {
                if (matriu[i][j] == 0) {
                    car = "   ";
                } else if (matriu[i][j] == 1) {
                    car = " . ";
                } else if (matriu[i][j]==SIMBOL_MINA) {
                    car = " * ";
                }
                System.out.print(matriu[i][j]);
            }
            System.out.println("|");
        }
    }
    
}
