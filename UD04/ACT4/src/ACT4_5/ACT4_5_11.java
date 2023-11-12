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

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NMINES=UtilitatsConsola.llegirSencer("Nombre de mines: ");
        tauler = new int[NTAULER][NTAULER];  // matriu matriu NTAULERxNTAULER
        int[] posXY = new int[2];

        emplenaTauler(tauler, mines);
        
        do {
            mostrarTauler(tauler);
            posXY[0] = UtilitatsConsola.llegirSencer("Posició X: ");
            posXY[1] = UtilitatsConsola.llegirSencer("Posició Y: ");
            System.out.println(posXY[0]+"-"+posXY[1]);
            desactivarPosicio(tauler, posXY);
            
        } while (posXY[1] != 0);
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
        //
        puntuarMines(tauler, mines);
    }
    
    public static void puntuarMines(int[][] tauler, ArrayList<int[]> mines) {
        int[] posMina = new int[2];
        
        for (int m=0; m<mines.size();m++) {
            posMina = new int[] { mines.get(m)[0],
                                  mines.get(m)[1]
                                };
            //
            for (int i=Math.max(0, posMina[0]-1); i <= Math.min(tauler.length-1, posMina[0]+1); i++) {
                for (int j=Math.max(0, posMina[1]-1); j <= Math.min(tauler.length-1, posMina[1]+1); j++) {
                    if (tauler[i][j]!=SIMBOL_MINA) {
                        tauler[i][j]++;
                    }
                }
            }
        }
    }
    public static void desactivarPosicio(int[][] tauler, int[] posXY) {
        int[] posXXYY= new int[2];
        
        if (tauler[posXY[0]][posXY[1]]==0) {
            tauler[posXY[0]][posXY[1]] = -1;
            //
            for (int i=Math.max(0, posXY[0]-1); i <= Math.min(tauler.length-1, posXY[0]+1); i++) {
                for (int j=Math.max(0, posXY[1]-1); j <= Math.min(tauler.length-1, posXY[1]+1); j++) {
                    if (tauler[i][j] == 0) {
                        posXXYY[0] = i; posXXYY[1]=j;
                        desactivarPosicio(tauler, posXXYY);
                    }
                }
            }
        }
    }
    public static void mostrarTauler(int[][] matriu) {
        String car="";
        for (int i = 0; i < matriu.length; i++) {
            System.out.print('|');
            for (int j = 0; j < matriu[i].length; j++) {
                if (matriu[i][j] == SIMBOL_BUIT) {
                    car = " _ ";
                } else if (matriu[i][j]==SIMBOL_MINA) {
                    car = " * ";
                } else if (matriu[i][j]==-1) {
                    car = "   ";
                } else 
                    car = " " + String.valueOf(matriu[i][j]) + " ";
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
    
}
