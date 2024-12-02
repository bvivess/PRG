package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;
import java.util.Arrays;


 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuaci� gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del cuc
  */

public class ACT4_6_C2 { 
    static int NTAULER;
    static int NFULLES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_FULLA = 99;
    static final int SIMBOL_CUC = 1;
    static final int SIMBOL_CAPCUC = 2;
    static int[][] tauler;
    static ArrayList<int[]> cuc = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> [a,b] �s el cap, [m,n] �s la cua 
    static ArrayList<int[]> fulles = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> posici� de les fulles
    static int accio;

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        emplenaTauler(tauler, cuc, fulles);
        
        do {
            mostrarTauler(tauler, cuc, fulles);
            accio = UtilitatsConsola.llegirSencer("Puntuaci�: " + cuc.size() +  " | 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            if ((accio == 2) | (accio == 4)| (accio == 6)| (accio == 8))
                if (cambiaPosicio(tauler, cuc, fulles, accio)) {
                    if (fulles.size() == 0) {
                        System.out.println("YOU WIN !!");
                        accio = 0;
                    }
                } else {
                    System.out.println("YOU LOSE !!");
                    accio = 0;
                }
        } while (accio != 0);
    }
    
    public static void emplenaTauler(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        // Genera posici� Inicial cuc
        int[] posCuc = UtilitatsArrays.generaArray(2,0, tauler.length-1);
        cuc.add(posCuc);
      
        // Genera posici� de cada fulla 
        for (int i=0; i<NFULLES; i++) {
            afegeixFulla(tauler, cuc, fulles);
        }
    }
    
    public static void afegeixFulla(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        ArrayList<int[]> unio = new ArrayList<>();
        int[] posNovaFulla;  // posicio nova fulla
        boolean okFulla = true;

        unio.addAll(cuc);
        unio.addAll(fulles);
        
        do {
            posNovaFulla  = UtilitatsArrays.generaArray(2,0, NTAULER-1); // genera posici� de la fulla
            // Recorre 'fulles' per veure que 'posFulla' �s correcta
            okFulla = true;
            for (int[] pos : unio) {
                if (Arrays.equals(pos,posNovaFulla)) {
                    okFulla = false;
                    break;
                }
            }
        } while (!okFulla);
        
        // Afegeix fulla
        fulles.add(posNovaFulla);
    }
    
    public static boolean cambiaPosicio(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles, int accio) {
        int mida = tauler.length;
        int[] posFulla, posCuc;
        int[] posCucCap = new int[] { cuc.get(cuc.size()-1)[0],
                                      cuc.get(cuc.size()-1)[1] }; // posici� actual del cap �s la darrera posici� de l'arraylist
        int[] posCucCua = new int[] { cuc.get(0)[0],
                                      cuc.get(0)[1] };  // posici� actual de la cua �s la primera posici� de l'arraylist
        
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
        
        // Cuc menja fulla ?
        for (int i=0; i < fulles.size(); i++) {
            posFulla = fulles.get(i);
            if (Arrays.equals(posFulla,posCucCap)) {
                cuc.add(posCucCap);
                fulles.remove(i);
                return true;
            }
        }
        
        // Cuc es tropitja ?
        for (int i=0; i < cuc.size(); i++) {
            posCuc = cuc.get(i);
            if (Arrays.equals(posCuc,posCucCap)) {
                return false;
            }
        }
        
        // Cuc en simbol_buit
        cuc.add(posCucCap); // afegim posCuc a cuc
        cuc.remove(0);  // eliminam cua a cuc

        return true;       
    }

    
    public static void netejaTauler(int[][] tauler){
        for (int i = 0; i < tauler.length; i++) 
            for (int j = 0; j < tauler[i].length; j++)
                tauler[i][j] = SIMBOL_BUIT;
    }    

    public static void situaCuc(int[][] tauler, ArrayList<int[]> cuc){
        int i=0;
        for (int[] pos : cuc) {
            tauler[pos[0]][pos[1]] = (i==cuc.size()-1 ? SIMBOL_CAPCUC: SIMBOL_CUC);
            i++;
        }
    }
    
    public static void situaFulles(int[][] tauler, ArrayList<int[]> fulles){
        for (int[] pos : fulles) {
            tauler[pos[0]][pos[1]] = SIMBOL_FULLA;
        }
    }
 
    public static void mostrarTauler(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        String car="";
        
        netejaTauler(tauler);
        situaCuc(tauler, cuc);
        situaFulles(tauler, fulles);
        
        UtilitatsMatrius.mostrarMatriu(tauler);
        
        for (int i = 0; i < tauler.length; i++) {
            System.out.print('|');
            for (int j = 0; j < tauler[i].length; j++) {
                switch (tauler[i][j]) {
                    case SIMBOL_BUIT -> car = "   ";
                    case SIMBOL_FULLA -> car = " * ";
                    case SIMBOL_CAPCUC -> car = " O ";
                    case SIMBOL_CUC -> car = " . ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
    
}
