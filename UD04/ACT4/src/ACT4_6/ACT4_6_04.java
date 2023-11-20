package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;
//import ACT4_2.UtilitatsMatrius;


 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuaciÃ³ gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del cuc
  */

public class ACT4_6_04 { 
    static int NTAULER;
    static int NFULLES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_FULLA = 99;
    static int SIMBOL_CUC = 1;
    static final int SIMBOL_CAPCUC = 2;
    static int[][] tauler;
    static ArrayList<int[]> cuc = new ArrayList<>();
    static int accio;

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        tauler = new int[NTAULER][NTAULER];  // matriu matriu NTAULERxNTAULER
        emplenaTauler(tauler, cuc);
        
        do {
            mostrarTauler(tauler);
            accio = UtilitatsConsola.llegirSencer("Puntuació: " + cuc.size() +  " | 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            if ((accio == 2) | (accio == 4)| (accio == 6)| (accio == 8)) {
                cambiaPosicio(tauler, cuc, accio);
            }
            if (SIMBOL_CUC == SIMBOL_BUIT-1) {
                System.out.println("You lose");
                accio = 0;
            } else if (cuc.size() == (NTAULER*NTAULER) - NFULLES) {
                System.out.println("YOU WIN !!!");
                accio = 0;
            }
        } while (accio != 0);
    }
    
    public static void emplenaTauler(int[][] tauler, ArrayList<int[]> cuc) {
        final int MINIM = 0, MAXIM = tauler.length-1;
        int[] fulla;
        int[] posCuc = UtilitatsArrays.generaArray(2,0, tauler.length-1);

        // Genera posició Inicial cuc
        cuc.add(posCuc);
        
        // Situa cuc en el tauler
        tauler[posCuc[0]][posCuc[1]] = SIMBOL_CAPCUC;
        
        // Genera posició de cada fulla i situa en el tauler
        for (int i=0; i<NFULLES; i++) {
            afegeixFulla(tauler);
        }
    }
    
    public static void afegeixFulla(int[][] tauler) {
        int mida = tauler.length;
        int[] fulla;
        boolean okfulla = true;
        
        do {
            fulla  = UtilitatsArrays.generaArray(2,0, mida-1); // genera posiciÃ³ de la fulla
            if (tauler[fulla[0]][fulla[1]] == 0) { // situa la fulla al tauler si la posiciÃ³ estÃ  buida
                tauler[fulla[0]][fulla[1]] = SIMBOL_FULLA;
                okfulla = false;
            }
        } while (okfulla);
        
    }
    
    public static void cambiaPosicio(int[][] tauler, ArrayList<int[]> cuc, int accio) {
        int mida = tauler.length;
        int[] posCucCap = new int[] { cuc.get(cuc.size()-1)[0],
                                      cuc.get(cuc.size()-1)[1] }; // (x,y) del cap
        int[] posCucCua = new int[] { cuc.get(0)[0],
                                      cuc.get(0)[1] };  // (x,y) de la cua
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
            tauler[posCucCap[0]][posCucCap[1]] = SIMBOL_CAPCUC;
            
            afegeixFulla(tauler); // nova fulla
        } else if ((tauler[posCucCap[0]][posCucCap[1]]) == SIMBOL_BUIT) {  // cuc es mou
            cuc.add(posCucCap); // afegim posCuc a cuc
            tauler[posCucCap[0]][posCucCap[1]] = SIMBOL_CAPCUC;
            cuc.remove(0);  // eliminam cua a cuc
            tauler[posCucCua[0]][posCucCua[1]] = SIMBOL_BUIT;
        } else {                                                // cuc es tropitja
            SIMBOL_CUC = SIMBOL_BUIT-1;                         // tornam -1 --> fi de la partida !!!
        }
    }
 
    public static void mostrarTauler(int[][] matriu) {
        String car="";
        for (int i = 0; i < matriu.length; i++) {
            System.out.print('|');
            for (int j = 0; j < matriu[i].length; j++) {
                if (matriu[i][j] == 0) {
                    car = "   ";
                } else if (matriu[i][j] == SIMBOL_CUC) {
                    car = " . ";
                } else if (matriu[i][j]==SIMBOL_FULLA) {
                    car = " * ";
                } else if (matriu[i][j]==SIMBOL_CAPCUC) {
                    car = " O ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
    
}
