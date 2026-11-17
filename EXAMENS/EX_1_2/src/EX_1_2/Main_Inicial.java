package EX_1_2;

import EX_1_2.UtilitatsArrays;
import EX_1_2.UtilitatsConsola;


public class Main_Inicial {
    static int NTAULER=0, NMURS, NCOCOS, NFANTASMES;
    final static int SIMBOL_BUIT=0, SIMBOL_PACMAN=1, SIMBOL_MUR=3, SIMBOL_FANTASME=5, SIMBOL_COCO=9;
    
    public static void main(String[] args) {
        int[][] tauler = new int[NTAULER][NTAULER];
        int[] pacman = new int[2];    // {fila, columna}

        int accio;
        boolean pacmanAtrapat = false;

        inicialitzaJoc(tauler, pacman);

        do {
            mostraTauler(tauler);

            accio = UtilitatsConsola.llegirSencer("Cocos restants: " + NCOCOS + " - ACCIONS: 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");

            // Cambiar la posició de Pacman 
            pacmanAtrapat = cambiaPosicio(tauler, pacman, accio);
        } while (accio != 0 && !pacmanAtrapat && NCOCOS > 0);

        /** Mostrar el resultat final:
         *    - si s'ha GUANYAT (NCOCOS == 0)
         *    - si s'ha PERDUT (pacmanAtrapat==true)
         *    - sino, l'usuari ha sortit voluntariament
        */

    }

    public static void inicialitzaJoc(int[][] tauler, int[] pacman) {
        /** Situar els elements del joc sobre el tauler: 
         *    - pacman,
         *    - cocos,
         *    - murs,
         *    - fantasmes
        */
        
    }

    /**
     * Mou el Pac-Man amb efecte túnel si no hi ha un mur i retorna
     * què hi havia a la casella destí abans d'ocupar-la.
     */
    public static boolean cambiaPosicio(int[][] tauler, int[] pacman, int accio) {
        /** Calcula la nova posició de pacman i situa'l sobre el tauler
         * tenint en compte si s'hi troba:
         *   - murs: no cal moure, 
         *   - fantasmes: es perd la partida
         *   - coco: es dscompta NCOCOS
        */

        return true|false;
    }

    public static void mostraTauler(int[][] tauler) {
        /** Mostra el tauler segons:
         *   SIMBOL_BUIT ? "   " (3 espais)
         *   SIMBOL_PACMAN ? " C "
         *   SIMBOL_MUR ? " # "
         *   SIMBOL_FANTASMA ? " F "
         *   SIMBOL_COCO ? " * " 
        */
        String car = "   ";
        for (int i = 0; i < NTAULER; i++) {
            System.out.print('|');
            for (int j = 0; j < NTAULER; j++) {
                switch (tauler[i][j]) {
                    case SIMBOL_BUIT -> car = "   ";
                    case SIMBOL_PACMAN -> car = " C ";
                    case SIMBOL_MUR -> car = " # ";
                    case SIMBOL_FANTASME -> car = " F ";
                    case SIMBOL_COCO -> car = " * ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
}