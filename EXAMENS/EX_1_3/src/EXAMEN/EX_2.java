package EXAMEN;

import java.util.ArrayList;
import java.util.Arrays;


 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuació gestiona el joc del peoBlanc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del peoBlanc
  */

public class EX_2 { 
    static int NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
    static int NPEONS_NEGRES = UtilitatsConsola.llegirSencer("Nombre de peonsNegres: ");
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_PEO_BLANC = 1;
    static final int SIMBOL_PEO_NEGRE = 9;
    
    public static void main(String[] args) {
        int[][] tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        int[] peoBlanc = UtilitatsArrays.generaArray(2,0, NTAULER-1);  // [[m,n][k,l]...[a,b]] --> [a,b] és el cap del peoBlanc, [m,n] és la cua 
        ArrayList<int[]> peonsNegres = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> posició de les peonsNegres
        int accio;
        
        inicialitzaJoc(tauler, peoBlanc, peonsNegres);
        
        do {
            mostrarTauler(tauler, peoBlanc, peonsNegres);
            accio = UtilitatsConsola.llegirSencer("8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");

            if (cambiaPosicio(tauler, peoBlanc, peonsNegres, accio)) {
                if (peonsNegres.isEmpty()) {
                    System.out.println("YOU WIN !!");
                    accio = 0;
                }
            } else {
                System.out.println("YOU LOSE !!");
                accio = 0;
            }
        } while (accio != 0);
    }
    
    public static void inicialitzaJoc(int[][] tauler, int[] peoBlanc, ArrayList<int[]> peonsNegres) {
        // Genera posició Inicial peoBlanc
        //int[] pos = UtilitatsArrays.generaArray(2,0, NTAULER-1);
        //peoBlanc = pos;
      
        // Genera posició de cada fulla 
        for (int i=0; i < NPEONS_NEGRES; i++)
            afegeixUnaFulla(tauler, peoBlanc, peonsNegres);
    }
    
    public static void afegeixUnaFulla(int[][] tauler, int[] peoBlanc, ArrayList<int[]> peonsNegres) {
        ArrayList<int[]> peons = new ArrayList<>(peonsNegres);
        int[] pos;  // posicio nova fulla
        boolean okPeo;

        // Recorre 'peoBlanc' + 'peonsNegres' per veure que 'posFulla' és correcta
        peons.add(peoBlanc);  // afegeix 'peoBlanc' a peoBlancIpeonsNegres'
        
        
        do {
            pos  = UtilitatsArrays.generaArray(2,0, NTAULER-1); // genera posició de la fulla
            
            // Recorre 'peoBlanc' i 'peonsNegres' per veure que 'posFulla' és correcta
            okPeo = true;
            for (int[] p : peons) {
                if (Arrays.equals(p, pos)) {
                    okPeo = false;
                    break;
                }
            }
        } while (!okPeo);
        
        // Afegeix fulla
        peonsNegres.add(pos);
    }
    
    public static boolean cambiaPosicio(int[][] tauler, int[] peoBlanc, ArrayList<int[]> peonsNegres, int accio) {  // torna 'true' si el 'peoBlanc' es tropitja, 'false' en cas contrari
        int[] pos;
        
        switch (accio) {
            case 7 -> {  // DIAGONAL ALT-ESQ
                peoBlanc[0] = (peoBlanc[0] == 0 ? NTAULER-1 : --peoBlanc[0]);
                peoBlanc[1] = (peoBlanc[1] == 0 ? NTAULER-1 : --peoBlanc[1]);
            }
            case 9 -> {  // DIAGONAL ALT-DRETA
                peoBlanc[0] = (peoBlanc[0] == 0 ? NTAULER-1 : --peoBlanc[0]);
                peoBlanc[1] = (peoBlanc[1] == NTAULER-1 ? 0 : ++peoBlanc[1]);
            }
            case 1 -> {  // DIAGONAL BAIX-ESQ
                peoBlanc[0] = (peoBlanc[0] == NTAULER-1 ? 0 : ++peoBlanc[0]);
                peoBlanc[1] = (peoBlanc[1] == 0 ? NTAULER-1 : --peoBlanc[1]);
            }
            case 3 -> {  // DIAGONAL BAIX-DRETA
                peoBlanc[0] = (peoBlanc[0] == NTAULER-1 ? 0 : ++peoBlanc[0]);
                peoBlanc[1] = (peoBlanc[1] == NTAULER-1 ? 0 : ++peoBlanc[1]);
            }
            case 8  -> // ALT
                peoBlanc[0] = (peoBlanc[0] == 0 ? NTAULER-1 : --peoBlanc[0]); 
            case 2 -> //BAIX
                peoBlanc[0] = (peoBlanc[0] == NTAULER-1 ? 0 : ++peoBlanc[0]); 
        }
        
        // Peó menja Peó ?
        for (int i=0; i < peonsNegres.size(); i++) {
            pos = peonsNegres.get(i);
            if (Arrays.equals(pos,peoBlanc)) {
                peonsNegres.remove(i);
                return true;
            }
        }

        return true;       
    }
 
    public static void mostrarTauler(int[][] tauler, int[] peoBlanc, ArrayList<int[]> peonsNegres) {
        String car="";
        
        netejaTauler(tauler);
        situaPeoBlanc(tauler, peoBlanc);
        situaPeonsNegres(tauler, peonsNegres);
        
        for (int i = 0; i < NTAULER ; i++) {
            System.out.print('|');
            for (int j = 0; j < NTAULER; j++) {
                switch (tauler[i][j]) {
                    case SIMBOL_BUIT -> car = "   ";
                    case SIMBOL_PEO_NEGRE -> car = " * ";
                    case SIMBOL_PEO_BLANC -> car = " O ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
    
     public static void netejaTauler(int[][] tauler){
        for (int i = 0; i < tauler.length; i++) 
            for (int j = 0; j < tauler[i].length; j++)
                tauler[i][j] = SIMBOL_BUIT;
    }    

    public static void situaPeoBlanc(int[][] tauler, int[] peoBlanc){
        tauler[peoBlanc[0]][peoBlanc[1]] = SIMBOL_PEO_BLANC;
    }
    
    public static void situaPeonsNegres(int[][] tauler, ArrayList<int[]> peonsNegres){
        for (int[] pos : peonsNegres) {
            tauler[pos[0]][pos[1]] = SIMBOL_PEO_NEGRE;
        }
    }   
}


