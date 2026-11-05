package CUC;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 5x5:
  *      Mostra-la per pantalla, cada fila a una lÃ­nia.
  */
public class ACT4_6_A1 {
    static final int NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
    static final int NFULLES = UtilitatsConsola.llegirSencer("Número fulles: ");
    static int SIMBOL_BUIT = 0;
    static int SIMBOL_CUC = 1;
    static int SIMBOL_FULLA = 9;
 
    public static void main(String[] args) {
        int[][] tauler = new int[NTAULER][NTAULER];  // tauler del joc
        int[] cuc = new int[2];  // posició {fila,columna} del cuc
        int accio; 

        // Emplena el tauler amb el cuc i les fulles
        inicialitzaJoc(tauler, cuc);
        
        do {
            // Mostra el tauler
            //UtilitatsArrays.mostraArray(cuc);
            //UtilitatsMatrius.mostrarMatriu(tauler);
            mostrarTauler(tauler);
            
            // Cambia la posició del cuc
            accio=UtilitatsConsola.llegirSencer("ACCIONS: 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");     
            cambiaPosicio(tauler, cuc, accio);
        } while (accio!=0);
    }
    
    public static void inicialitzaJoc(int[][] tauler, int[] cuc) {
        // Generam una posició aleatòria pel cuc
        int[] pos = UtilitatsArrays.generaArray(2, 0, NTAULER-1);  // {2,4}
        
        cuc[0] = pos[0];
        cuc[1] = pos[1];
        
        // Situa cuc en el tauler
        tauler[ cuc[0] ] [ cuc[1] ] = SIMBOL_CUC;
        
        // Situa fulles
        for (int i=0;i<=NFULLES;i++) {
            // Colocar fulles
            boolean posFullaOK = false;
        
            do {
                pos = UtilitatsArrays.generaArray(2, 0, NTAULER-1);  // {2,4}
                if (tauler [ pos[0] ] [pos[1]] == SIMBOL_BUIT) {
                    posFullaOK = true;
                    tauler [ pos[0] ] [pos[1]] = SIMBOL_FULLA;
                }
            } while (!posFullaOK);
        }
    }
    
    public static void cambiaPosicio(int[][] tauler, int[] cuc, int accio) {
        tauler[ cuc[0] ] [ cuc[1] ] = SIMBOL_BUIT;
        
        if (accio == 4)        // ESQ
            if (cuc[1] == 0)
                cuc[1] = NTAULER - 1;
            else
                cuc[1]--;
        else if (accio == 6) // DRETA
            if (cuc[1] == NTAULER - 1)
                cuc[1] = 0;
           else
                cuc[1]++;
        else if (accio == 8) // ALT
            if (cuc[0] == 0)
                cuc[0] = NTAULER - 1;
            else
                cuc[0]--;
        else if (accio == 2) // BAIX
            if (cuc[0] == NTAULER - 1)
                cuc[0] = 0;
            else
                cuc[0]++;

        tauler[ cuc[0] ] [ cuc[1] ] = SIMBOL_CUC;
    }
    
    public static void mostrarTauler(int[][] tauler) {
        String car = "   ";
        for (int i = 0; i < NTAULER; i++) {
            System.out.print('|');
            for (int j = 0; j < NTAULER; j++) {
                if (tauler[i][j] == SIMBOL_BUIT)
                    car = "   ";
                else if (tauler[i][j] == SIMBOL_CUC)
                    car = " O ";
                else if (tauler[i][j] == SIMBOL_FULLA)
                    car = " * ";

                System.out.print(car);
            }
            System.out.println("|");
        }
    }
    
}

