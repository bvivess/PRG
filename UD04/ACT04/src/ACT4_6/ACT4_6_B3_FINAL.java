package ACT4_6;
import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;
import java.util.Arrays;


 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuació gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del cuc
  */

public class ACT4_6_B3_FINAL { 
    static int NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
    static int NFULLES = UtilitatsConsola.llegirSencer("Nombre de fulles: ");
    static final char SIMBOL_BUIT = ' ';
    static final char SIMBOL_FULLA = '*';
    static final char SIMBOL_CUC = '.';
    static final char SIMBOL_CAPCUC = 'O';

    public static void main(String[] args) {
        char[][] tauler = new char[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        ArrayList<int[]> cuc = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> [a,b] és el cap del cuc, [m,n] és la cua 
        ArrayList<int[]> fulles = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> posició de les fulles
        int accio;
        boolean cucEsTropitja = false;
        
        inicialitzaJoc(tauler, cuc, fulles);
        
        do {
            mostrarTauler(tauler, cuc, fulles);
            accio = UtilitatsConsola.llegirSencer("Puntuació: " + cuc.size() +  " | 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            
            cucEsTropitja = cambiaPosicio(tauler, cuc, fulles, accio);

        } while (accio != 0 && !cucEsTropitja && !fulles.isEmpty());
        
        // Final del joc
        if (cucEsTropitja)
            System.out.println("GAME OVER: El cuc s'ha tropitjat!!!");
        else if (fulles.isEmpty())
            System.out.println("GAME OVER: T'has menjat totes les fulles!!!");
        else
            System.out.println("GAME OVER: Partida finalitzada per l'usuari.");
    }
    
    public static void inicialitzaJoc(char[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        // Genera posició Inicial cuc
        int[] pos = UtilitatsArrays.generaArray(2,0, NTAULER-1);
        cuc.add(pos);
      
        // Genera posició de cada fulla 
        for (int i=0; i<NFULLES; i++)
            afegeixUnaFulla(tauler, cuc, fulles);
    }
    
    public static void afegeixUnaFulla(char[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        ArrayList<int[]> cucIfulles = new ArrayList<>();
        int[] pos;  // posicio nova fulla
        boolean okFulla;

        // Recorre 'cuc' + 'fulles' per veure que 'posFulla' és correcta
        cucIfulles.addAll(cuc);  // afegeix 'cuc' a cucIfulles'
        cucIfulles.addAll(fulles);  // afegeix 'fulles' a cucIfulles'
        
        do {
            pos  = UtilitatsArrays.generaArray(2,0, NTAULER-1); // genera posició de la fulla
            
            // Recorre 'cuc' i 'fulles' per veure que 'posFulla' és correcta
            okFulla = true;
            for (int[] p : cucIfulles) {
                if (Arrays.equals(p, pos)) {
                    okFulla = false;
                    break;
                }
            }
        } while (!okFulla);
        
        // Afegeix fulla
        fulles.add(pos);
    }
    
    public static boolean cambiaPosicio(char[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles, int accio) {  // torna 'true' si el 'cuc' es tropitja, 'false' en cas contrari
        int[] pos;
        int[] novaPos = { cuc.get(cuc.size() - 1)[0], 
                          cuc.get(cuc.size() - 1)[1] }; // posició actual del cap és la darrera posició de l'arraylist
        
        switch (accio) {
            case 4 -> // ESQ
                novaPos[1] = (novaPos[1] == 0 ? NTAULER-1 : --novaPos[1]); 
            case 6  -> // DRETA
                novaPos[1] = (novaPos[1] == NTAULER-1 ? 0 : ++novaPos[1]); 
            case 8  -> // ALT
                novaPos[0] = (novaPos[0] == 0 ? NTAULER-1 : --novaPos[0]); 
            case 2 -> //BAIX
                novaPos[0] = (novaPos[0] == NTAULER-1 ? 0 : ++novaPos[0]); 
        }
        
        // Cuc menja fulla ?: el cuc està on hi ha alguna fulla 
        for (int i=0; i < fulles.size(); i++) {
            pos = fulles.get(i);
            if (Arrays.equals(pos,novaPos)) {
                cuc.add(novaPos);
                fulles.remove(i);
                return false;
            }
        }
        
        // Cuc es tropitja ?: el cap està on hi ha alguna part del cuc
        for (int i=0; i < cuc.size(); i++) {
            pos = cuc.get(i);
            if (Arrays.equals(pos,novaPos)) {
                return true;
            }
        }
        
        // Cuc es mou: si no menja fulla ni es tropitja, simplement cal moure el cap
        cuc.add(novaPos); // afegim posCuc a cuc
        cuc.remove(0);  // eliminam cua a cuc

        return false;       
    }
 
    public static void mostrarTauler(char[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        String car="";
        
        netejaTauler(tauler);
        situaCuc(tauler, cuc);
        situaFulles(tauler, fulles);
              
        for (int i = 0; i < NTAULER ; i++) {
            System.out.print('|');
            for (int j = 0; j < NTAULER; j++) 
                System.out.print(" " + tauler[i][j] + " ");
            System.out.println("|");
        }
    }
    
     public static void netejaTauler(char[][] tauler){
        for (int i = 0; i < tauler.length; i++) 
            for (int j = 0; j < tauler[i].length; j++)
                tauler[i][j] = SIMBOL_BUIT;
    }    

    public static void situaCuc(char[][] tauler, ArrayList<int[]> cuc){
        int i=0;
        for (int[] posCuc : cuc) {
            tauler[posCuc[0]][posCuc[1]] = (i==cuc.size()-1 ? SIMBOL_CAPCUC: SIMBOL_CUC);
            i++;
        }
    }
    
    public static void situaFulles(char[][] tauler, ArrayList<int[]> fulles){
        for (int[] posFulla : fulles) {
            tauler[posFulla[0]][posFulla[1]] = SIMBOL_FULLA;
        }
    }  
    
}
