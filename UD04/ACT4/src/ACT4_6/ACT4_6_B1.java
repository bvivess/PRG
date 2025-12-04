package ACT4_6;

import java.util.ArrayList;
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

public class ACT4_6_B1 { 
    static int NTAULER;
    static int NFULLES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_FULLA = 9;
    static final int SIMBOL_CUC = 1;
    static final int SIMBOL_CAPCUC = 2;
    static int[][] tauler;
    static ArrayList<int[]> cuc = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> [a,b] és el cap del cuc, [m,n] és la cua 
    static ArrayList<int[]> fulles = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> posició de les fulles
    static int accio;

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        emplenaTauler(tauler, cuc, fulles);
        
        do {
            mostrarTauler(tauler, cuc, fulles);  //
            accio = UtilitatsConsola.llegirSencer("Puntuació: " + cuc.size() +  " | 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            if (cambiaPosicio(tauler, cuc, fulles, accio)) {
                if (fulles.isEmpty()) {
                    System.out.println("YOU WIN !!");
                    accio = 0;
                }
            } else {
                System.out.println("YOU LOSE !!");
                accio = 0;
            }
            
        } while (accio != 0);
    }
    
    /**
     * @param tauler
     * @param cuc
     * @param fulles 
     * 
     * Ha de rebre el 'tauler' buit i ha de crear :
     *      - el 'cuc'
     *      - les 'fulles'
     */
    public static void emplenaTauler(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        int[] pos;  // posició genèrica (x,y)
        
        // Genera posició Inicial cuc
        pos = UtilitatsArrays.generaArray(2,0, tauler.length-1);
        cuc.add(pos);
        tauler[pos[0]][pos[1]] = SIMBOL_CUC;
      
        // Situam les fulles:
        int nfulles = 0;
        while (nfulles < NFULLES) {
            // Generam una posició aleatòria per a una fulla
            pos = UtilitatsArrays.generaArray(2, 0, NTAULER-1);
            if (tauler[pos[0]][pos[1]] == SIMBOL_BUIT) {
              tauler[pos[0]][pos[1]] = SIMBOL_FULLA;
              fulles.add(pos);
              nfulles++;
            }
        }

    }
    
    /**
    * @param tauler
    * @param cuc
    * @param fulles
    * @param accio 
    * @return 'false' si el 'cuc' es tropija a sí mateix, 'true' en cas contrari
    * 
    * Ha de rebre el 'tauler', el 'cuc', les 'fulles' i l''acció :
    * 
    * El moviment es fa de la següent manera:
    *       - qui es mou es el cap: 
    *           int[] posCucCap = new int[] { cuc.get(cuc.size()-1)[0],
    *                                         cuc.get(cuc.size()-1)[1] };
    *       - El cap es mou segons:
    *         switch (accio) {
    *           case 4 -> // ESQ
    *               posCucCap[1] = (posCucCap[1] == 0 ? mida-1 : posCucCap[1]-1); 
    *           case 6  -> // DRETA
    *               posCucCap[1] = (posCucCap[1] == mida-1 ? 0 : posCucCap[1]+1); 
    *           case 8  -> // ALT
    *            posCucCap[0] = (posCucCap[0] == 0 ? mida-1 : posCucCap[0]-1); 
    *           case 2 -> //BAIX
    *               posCucCap[0] = (posCucCap[0] == mida-1 ? 0 : posCucCap[0]+1); 
    *         }
    *       - una vegada el es sap el moviment del cap, cal demanar-se:
    *           - el cuc es tropitja a sí mateix ?
    *               posCucCap es igual a alguna de les posicions (x,y) de 'cuc'
    *           - o bé, el cuc menja una fulla ?
    *               posCucCap es igual a alguna de les posicions (x,y) de 'fulles' ? si ho és cal eliminar aquesta posició de 'fulles' i afegir posCapCuc al 'cuc'
    *           - o bé, el cuc es mou:
    *               afegir posCapCuc al 'cuc' i eliminar la primera posició de 'cuc
    * 
    * 
    * 
     */
    public static boolean cambiaPosicio(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles, int accio) {  // torna 'true' si el 'cuc' es tropitja, 'false' en cas contrari
        int mida = tauler.length;
        int[] posCucCap = new int[] { cuc.get(cuc.size()-1)[0],
                                      cuc.get(cuc.size()-1)[1] }; // posició actual del cap és la darrera posició de l'arraylist
        
        switch (accio) {
            case 4 -> // ESQ
                posCucCap[1] = (posCucCap[1] == 0 ? mida-1 : --posCucCap[1]); 
            case 6  -> // DRETA
                posCucCap[1] = (posCucCap[1] == mida-1 ? 0 : ++posCucCap[1]); 
            case 8  -> // ALT
                posCucCap[0] = (posCucCap[0] == 0 ? mida-1 : --posCucCap[0]); 
            case 2 -> //BAIX
                posCucCap[0] = (posCucCap[0] == mida-1 ? 0 : ++posCucCap[0]); 
        }
        
        // Moure el cuc: 
        //    'cuc' menja 'fulla' ? --> return true;
        //    'cuc' es tropitja ? --> return false;
        //    'cuc' es mou --> return true;
        
        return true || false;
    }
    
     /**
     * 
     * @param tauler
     * @param cuc
     * @param fulles 
     * 
     * Ha de rebre 'tauler' i ha de col·locar cada simbol en aquest
     */
    
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
    
    /**
    * Posa tot el 'tauler' a SIMBOL_BUIT
    */
    
    public static void netejaTauler(int[][] tauler){
        for (int i = 0; i < tauler.length; i++) 
            for (int j = 0; j < tauler[i].length; j++)
                tauler[i][j] = SIMBOL_BUIT;
    }  
    
    /**
     * @param tauler
     * @param cuc 
     * 
     * Ha de rebre el 'tauler', ha de recorre 'cuc' i ha de modificar 'tauler' segon:
     *      - cap -> SIMBOL_CAPCUC
     *      - resta del cos -> SIMBOL_CUC
     *      
     */
    public static void situaCuc(int[][] tauler, ArrayList<int[]> cuc){
        // Recorre 'cuc' i posar SIMBOL_CAPCUC o SIMBOL_CUC en el tauler
    }
    
    /**
     * @param tauler
     * @param fulles
     * 
     * Ha de rebre el 'tauler', ha de recorre 'fulles' i ha de modificar 'tauler' segon:
     *      - fulla -> SIMBOL_FULLA
     *      
     */
    public static void situaFulles(int[][] tauler, ArrayList<int[]> fulles){
        // Recorre 'fulles' i posar SIMBOL_FULLA en el tauler
    }
    
}
