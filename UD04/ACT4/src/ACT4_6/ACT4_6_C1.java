package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;



 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuació gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del cuc
  */

public class ACT4_6_C1 { 
    static int NTAULER;
    static int NFULLES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_FULLA = 99;
    static final int SIMBOL_CUC = 1;
    static final int SIMBOL_CAPCUC = 2;
    static int[][] tauler;
    static ArrayList<int[]> cuc = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> [a,b] és el cap, [m,n] és la cua 
    static ArrayList<int[]> fulles = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> posició de les fulles
    static int accio;

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        emplenaTauler(tauler, cuc, fulles);
        
        do {
            mostrarTauler(tauler, cuc, fulles);
            accio = UtilitatsConsola.llegirSencer("Puntuació: " + cuc.size() +  " | 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            
            
        } while (accio != 0);
    }
    
    public static void emplenaTauler(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        
        // Genera posició Inicial cuc
        int[] posCuc = UtilitatsArrays.generaArray(2,0, tauler.length-1);
        cuc.add(posCuc);
      
        // Genera posició de cada fulla 
        for (int i=0; i<NFULLES; i++) {
            afegeixFulla(tauler, cuc, fulles);
        }
    }
    
    public static void afegeixFulla(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        int[] posNovaFulla;  // posicio nova fulla
        boolean okFulla = true;
        
        do {
            posNovaFulla  = UtilitatsArrays.generaArray(2,0, NTAULER-1); // genera posició de la fulla
            // Recorre 'cuc' i 'fulles' per veure que 'posFulla' és correcta

        } while (!okFulla);
        
        // Afegeix fulla
        
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
        
        // Moure el cuc: 
       
    }
    
    public static void netejaTauler(int[][] tauler){
        for (int i = 0; i < tauler.length; i++) 
            for (int j = 0; j < tauler[i].length; j++)
                tauler[i][j] = SIMBOL_BUIT;
    }  
    
    public static void situaCuc(int[][] tauler, ArrayList<int[]> cuc){
        // Recorre 'cuc' i posar SIMBOL_CAPCUC o SIMBOL_CUC en el tauler
    }
    
    public static void situaFulles(int[][] tauler, ArrayList<int[]> fulles){
        // Recorre 'fulles' i posar SIMBOL_FULLA en el tauler
    }
 
    public static void mostrarTauler(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        String car="";
        
        netejaTauler(tauler);
        situaCuc(tauler, cuc);
        situaFulles(tauler, fulles);
        
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
