package ACT4_5;

import ACT4_1.UtilitatsArrays;
import static ACT4_2.UtilitatsMatrius.mostrarMatriu;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;
//import ACT4_2.UtilitatsMatrius;


public class ACT4_5_11 { 
    static int NTAULER;
    static int NMINES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_MINA = 9;
    static final int SIMBOL_DESACTIVAT = -1;
    static int[][] tauler;
    static boolean[][] taulerVisible;
    static ArrayList<int[]> mines = new ArrayList<>();

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NMINES=UtilitatsConsola.llegirSencer("Nombre de mines: ");
        tauler = new int[NTAULER][NTAULER];  // matriu matriu NTAULERxNTAULER
        taulerVisible = new boolean[NTAULER][NTAULER];
        int[] posXY = new int[2];

        emplenaTauler(tauler, mines);
        
        do {
            mostrarMatriu(tauler);
            
            mostrarTauler(tauler, taulerVisible);
            
            posXY[1] = UtilitatsConsola.llegirSencer("Posició X: ");
            posXY[0] = UtilitatsConsola.llegirSencer("Posició Y: ");
            
            if (desactivarPosicio(tauler, taulerVisible, posXY)==-1) {
                System.out.println("You lose !!!");
                break;
            }
            
        } while (posXY[1] >= 0);
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
    public static short desactivarPosicio(int[][] tauler, boolean[][] taulerVisible, int[] posXY) {
        int[] posXXYY= new int[2];
        short esMina = 0, dummy;
        
        taulerVisible[posXY[0]][posXY[1]] = true;
        
        if (tauler[posXY[0]][posXY[1]]==SIMBOL_BUIT) {
            tauler[posXY[0]][posXY[1]] = SIMBOL_DESACTIVAT;
            esMina = 0;
            // Propaga la desactivació als adjacents
            for (int i=Math.max(0, posXY[0]-1); i <= Math.min(tauler.length-1, posXY[0]+1); i++) {
                for (int j=Math.max(0, posXY[1]-1); j <= Math.min(tauler.length-1, posXY[1]+1); j++) {
                    taulerVisible[i][j] = true;
                    if (tauler[i][j] == 0) {
                        posXXYY[0] = i; posXXYY[1]=j;
                        dummy = desactivarPosicio(tauler, taulerVisible, posXXYY);
                    }
                }
            }
        } else if (tauler[posXY[0]][posXY[1]]==SIMBOL_MINA)
            esMina = -1;
        
        return esMina;
    }
    public static void mostrarTauler(int[][] tauler, boolean[][] taulerVisible) {
        String car;
        int numSIMBOL_BUIT = 0;
        
        System.out.print("   ");
        for (int i = 0; i < tauler.length; i++) {
            System.out.print(" "+i+" "); 
        }
        System.out.println("");
        for (int i = 0; i < tauler.length; i++) {
            System.out.print(i+" |");
            for (int j = 0; j < tauler[i].length; j++) {
                numSIMBOL_BUIT = numSIMBOL_BUIT + (tauler[i][j] == SIMBOL_BUIT ? 1: 0);
                if (taulerVisible[i][j]) {
                    if (tauler[i][j] == SIMBOL_BUIT) {
                        car = " _ ";
                    } else if (tauler[i][j]==SIMBOL_MINA) {
                        car = " * ";
                    } else if (tauler[i][j]==SIMBOL_DESACTIVAT) {
                        car = "   ";
                    } else 
                        car = " " + String.valueOf(tauler[i][j]) + " ";
                    System.out.print(car);
                } else
                    System.out.print(" x ");
            }
            System.out.println("|");
        }
        if (numSIMBOL_BUIT==0)
            System.out.println("You win !!!");
    }
    
}
