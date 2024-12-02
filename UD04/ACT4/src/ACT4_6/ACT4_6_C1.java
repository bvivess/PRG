package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;



 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuaciÃ³ gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del cuc
  */

public class ACT4_6_C1 { 
    static int NTAULER;
    static int NFULLES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_FULLA = 99;
    static int SIMBOL_CUC = 1;
    static final int SIMBOL_CAPCUC = 2;
    static int[][] tauler;
    static ArrayList<int[]> cuc = new ArrayList<>(); // [[m,n][k,l]...[a,b]] --> [a,b] és el cap, [m,n] és la cua 
    static int accio;

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
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
        pintaCuc(tauler,cuc);
        
        // Genera posició de cada fulla i situa en el tauler
        for (int i=0; i<NFULLES; i++) {
            afegeixFulla(tauler);
        }
    }
    
    public static void afegeixFulla(int[][] tauler) {
        int[] fulla;  // posicio nova fulla
        boolean okfulla = true;
        
        do {
            fulla  = UtilitatsArrays.generaArray(2,0, NTAULER-1); // genera posició de la fulla
            if (tauler[fulla[0]][fulla[1]] == SIMBOL_BUIT) { // situa la fulla al tauler si la posició està  buida
                tauler[fulla[0]][fulla[1]] = SIMBOL_FULLA;
                okfulla = false;
            }
        } while (okfulla);
    }
    
    public static void cambiaPosicio(int[][] tauler, ArrayList<int[]> cuc, int accio) {
        int mida = tauler.length;
        int[] posCucCap = new int[] { cuc.get(cuc.size()-1)[0],
                                      cuc.get(cuc.size()-1)[1] }; // posició actual del cap és la darrera posició de l'arraylist
        int[] posCucCua = new int[] { cuc.get(0)[0],
                                      cuc.get(0)[1] };  // posició actual de la cua és la primera posició de l'arraylist
        
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
        switch (tauler[posCucCap[0]][posCucCap[1]]) {
            case SIMBOL_FULLA -> { // cuc menja fulla
                cuc.add(posCucCap); // afegim posCuc a cuc
                afegeixFulla(tauler); // nova fulla
            }
            case SIMBOL_BUIT -> { // cuc es mou
                cuc.add(posCucCap); // afegim posCuc a cuc
                cuc.remove(0);  // eliminam cua a cuc
                tauler[posCucCua[0]][posCucCua[1]] = SIMBOL_BUIT;
            }
            default -> // cuc es tropitja
                SIMBOL_CUC = SIMBOL_BUIT-1;
            
        }

        pintaCuc(tauler,cuc);
    }
    
    public static void pintaCuc(int[][] tauler, ArrayList<int[]> cuc){
        int i=0;
        for (int[] pos : cuc) {
            tauler[pos[0]][pos[1]] = (i==cuc.size()-1 ? SIMBOL_CAPCUC: SIMBOL_CUC);
            i++;
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
