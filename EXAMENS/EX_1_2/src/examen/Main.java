package examen;

public class Main { 
    static int NTAULER;
    static final int SIMBOL_NEGRE = 1;
    static final int SIMBOL_VERMELL = 2;
    static final int SIMBOL_PEO = 8;
    static final int SIMBOL_COSTAT = 9;
    static int[][] tauler;
    
    public static void main(String[] args) {
        NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        
        emplenaCostats(tauler);
        UtilitatsMatrius.mostrarMatriu(tauler);

        emplenaInterior(tauler);
        UtilitatsMatrius.mostrarMatriu(tauler);

        situaPeo(tauler, SIMBOL_VERMELL);
        UtilitatsMatrius.mostrarMatriu(tauler);
        
        situaPeo(tauler, SIMBOL_NEGRE);
        UtilitatsMatrius.mostrarMatriu(tauler);

        mostraTauler(tauler);
    }
    
    public static void emplenaCostats(int [][] tauler) {
        /**
         * Ha de rebre un la matriu 'tauler' i ha d'emplenar els costats exteriors 
         * amb el valor 'SIMBOL_COSTAT'.
         */
        for (int i=0; i<NTAULER; i++) {
            tauler[0][i] = SIMBOL_COSTAT;
            tauler[i][0] = SIMBOL_COSTAT;
            tauler[NTAULER-1][i] = SIMBOL_COSTAT;
            tauler[i][NTAULER-1] = SIMBOL_COSTAT;
        }
    }
    
    public static void emplenaInterior(int [][] tauler) {
        /**
         * Ha de rebre un la matriu 'tauler' i ha d'emplenar les posicions alternes 
         * amb 'SIMBOL_NEGRE' i 'SIMBOL_VERMELL'
         */
        for (int i=1; i<NTAULER-1; i++)
            for (int j=1; j<NTAULER-1; j++)
                if (((i+j)%2)==0)
                    tauler[i][j] = SIMBOL_NEGRE;
                else
                    tauler[i][j] = SIMBOL_VERMELL;
    }
    
    public static void situaPeo(int [][] tauler, int simbol) {
        /**
         * Ha de rebre la matriu 'tauler' i ha de situar un 'SIMBOL_PEO'
         * en qualsevol posició aleatòria igual a 'SIMBOL_VERMELL'.
         */
        int[] peo;
        boolean sortir = false;
        
        do {
            peo = UtilitatsArrays.generaArray(SIMBOL_PEO, 1, NTAULER-2);
            if (tauler[peo[0]][peo[1]] == simbol) {
                tauler[peo[0]][peo[1]] = SIMBOL_PEO;
                sortir = true;
            }
        } while (!sortir);
    }
    
    public static void mostraTauler(int[][] matriu) {
        /**
         * Ha de rebre la matriu 'tauler' i ha de substituir cada símbol segons la següent taula:
            SIMBOL_VERMELL -> "  "
            SIMBOL_NEGRE -> " : "
            SIMBOL_PEO -> " Z "
            SIMBOL_COSTAT -> " | "
         */
        String car = "";
        for (int i = 0; i < NTAULER; i++) {
            //System.out.print('|');
            for (int j = 0; j < NTAULER; j++) {
                switch (matriu[i][j]) {
                    case SIMBOL_VERMELL -> car = "   ";
                    case SIMBOL_NEGRE -> car = " : ";
                    case SIMBOL_PEO -> car = " Z ";
                    case SIMBOL_COSTAT -> car = " | ";
                    default -> car = " ? ";
                };
                System.out.print(car);
            }
           System.out.println();
        }
    }
}

