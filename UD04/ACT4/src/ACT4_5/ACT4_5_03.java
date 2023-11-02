package ACT4_5;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuació gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del cuc
  */

public class ACT4_5_03 {  
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_FULLA = 99;
    static int SIMBOL_CUC = 1;
    static int[][] tauler;
    static int[] cuc;
    static int[][] fulles;
    static int accio;

    public static void main(String[] args) {
        final int NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        final int NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        //int longitudCuc = 1;
        tauler = new int[NTAULER][NTAULER];  // matriu matriu NTAULERxNTAULER
        cuc = new int[2];                    // array[2]--> (x,y) del cuc
        fulles = new int[NFULLES][2];        // array[NFULLES][2] --> (x,y) de cada fulla
        emplenaTauler(tauler, cuc, fulles);
        
        do {
            mostrarTauler(tauler, SIMBOL_CUC);
            accio = UtilitatsConsola.llegirSencer("Puntuació: " + (float) SIMBOL_CUC +  " | 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            if ((accio == 2) | (accio == 4)| (accio == 6)| (accio == 8)) {
                cambiarPosicio(tauler, cuc, accio);
                accio = (SIMBOL_CUC == SIMBOL_BUIT-1 ? 0 : accio); // fi de la partida ?
            }
        } while (accio != 0);
    }
    
    public static void emplenaTauler(int[][] tauler, int[] cuc, int[][] fulles) {
        final int MINIM = 0, MAXIM = tauler.length-1;
        
        // Genera posició cuc
        cuc[0]=(MINIM + (int) (Math.random() * (MAXIM - MINIM + 1)));
        cuc[1]=(MINIM + (int) (Math.random() * (MAXIM - MINIM + 1)));
       
        // Genera posició fulles
        for (int i=0; i<fulles.length; i++) {
            fulles[i] = UtilitatsArrays.generaArray(2,0, tauler.length-1);
        }
        
        // Situa cuc i fulles en el tauler
        tauler[cuc[0]][cuc[1]] = SIMBOL_CUC;
        SIMBOL_CUC = SIMBOL_CUC + 1;
        for (int i=0; i<fulles.length; i++) {
            tauler[ fulles[i][0]] [fulles[i][1] ] = SIMBOL_FULLA;
        }
    }
    
    public static void posicionarFulla(int[][] tauler) {
        int mida = tauler.length;
        int[] fulla;
        boolean ok = true;
        
        do {
            fulla  = UtilitatsArrays.generaArray(2,0, mida-1); // genera posició de la fulla
            if (tauler[fulla[0]][fulla[1]] == 0) { // situa la fulla al tauler si la posició està buida
                tauler[fulla[0]][fulla[1]] = SIMBOL_FULLA;
                ok = false;
            }
        } while (ok);
        
    }
    
    public static void cambiarPosicio(int[][] tauler, int[] posicio, int accio) {
        int mida = tauler.length;
 
        switch (accio) {
            case 4 -> // ESQ
                posicio[1] = (posicio[1] == 0 ? mida-1 : posicio[1]-1); 
            case 6  -> // DRETA
                posicio[1] = (posicio[1] == mida-1 ? 0 : posicio[1]+1); 
            case 8  -> // ALT
                posicio[0] = (posicio[0] == 0 ? mida-1 : posicio[0]-1); 
            case 2 -> //BAIX
                posicio[0] = (posicio[0] == mida-1 ? 0 : posicio[0]+1); 
        }
        // re-escriure el cuc
        if ((tauler[posicio[0]][posicio[1]]) == SIMBOL_FULLA) {  // cuc menja fulla
            SIMBOL_CUC++;
            tauler[posicio[0]][posicio[1]] = SIMBOL_CUC;
            
            posicionarFulla(tauler); // nova fulla
        } else if ((tauler[posicio[0]][posicio[1]]) == SIMBOL_BUIT) {  // cuc es mou
            for (int i=0; i<mida; i++) {
                for (int j=0; j<mida; j++) {
                    if ((tauler[i][j] > SIMBOL_BUIT) & (tauler[i][j] < SIMBOL_FULLA)) {
                        tauler[i][j] = tauler[i][j] - 1;
                    }
                }
            }
            tauler[posicio[0]][posicio[1]] = SIMBOL_CUC;
        } else {                                                // cuc es tropitja
            SIMBOL_CUC = SIMBOL_BUIT-1;                        // fi de la partida !!!
        }
        
        //return longitudCuc;
    }
 
    public static void mostrarTauler(int[][] matriu, int posicio) {
        String car;
        for (int i = 0; i < matriu.length; i++) {
            System.out.print('|');
            for (int j = 0; j < matriu[i].length; j++) {
                if (matriu[i][j] == 0) {
                    car = "   ";
                } else if (matriu[i][j] == 1) {
                    car = " . ";
                } else if (matriu[i][j]==99) {
                    car = " * ";
                } else if (matriu[i][j]==posicio) {
                    car = " O ";
                } else {
                    car = " - ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
    
}
