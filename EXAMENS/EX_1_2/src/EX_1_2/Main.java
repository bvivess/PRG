package EX_1_2;

/**
 * Avaluació Arrays i Matrius: Mini Pac-Man (versió simplificada).
 * SIMBOL_BUIT     --> 0 ("   ")
 * SIMBOL_PACMAN   --> 1 (" C ")
 * SIMBOL_MUR      --> 3 (" # ")
 * SIMBOL_FANTASMA --> 5 (" F ")
 * SIMBOL_COCO     --> 9 (" * ")
 */
public class Main {
    static final int NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
    static final int NMURS = UtilitatsConsola.llegirSencer("Numero de murs: ");
    static int NCOCOS = UtilitatsConsola.llegirSencer("Numero de cocos: ");
    static final int NFANTASMES = UtilitatsConsola.llegirSencer("Numero de fantasmes: ");

    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_PACMAN = 1;
    static final int SIMBOL_MUR = 3;
    static final int SIMBOL_FANTASME = 5;
    static final int SIMBOL_COCO = 9;

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
            pacmanAtrapat = (cambiaPosicio(tauler, pacman, accio));
        } while (accio != 0 && !pacmanAtrapat && NCOCOS > 0);

        /** Mostrar el resultat final:
         *    - si s'ha GUANYAT (NCOCOS == 0)
         *    - si s'ha PERDUT (pacmanAtrapat)
         *    - sino, l'usuari ha sortit voluntariament
        */
        mostraTauler(tauler);
        
        if (pacmanAtrapat)
            System.out.println("GAME OVER: El fantasma t'ha atrapat!!!");
        else if (NCOCOS == 0)
            System.out.println("GAME OVER: T'has menjat tots els cocos!!!");
        else
            System.out.println("GAME OVER: Partida finalitzada per l'usuari.");
    }

    public static void inicialitzaJoc(int[][] tauler, int[] pacman) {
        /** Situar els elements del joc sobre el tauler: 
         *    - pacman,
         *    - cocos,
         *    - murs,
         *    - fantasmes
        */
        
        // Situam el Pac-Man
        int[] pos = UtilitatsArrays.generaArray(2, 0, NTAULER - 1);
        pacman[0] = pos[0];
        pacman[1] = pos[1];
        tauler[pacman[0]][pacman[1]] = SIMBOL_PACMAN;
      
        // Situam els cocos en una casella buida
        for (int i = 0; i < NCOCOS; i++) {
            do {
                pos = UtilitatsArrays.generaArray(2, 0, NTAULER - 1);
            } while (tauler[pos[0]][pos[1]] != SIMBOL_BUIT);

            tauler[pos[0]][pos[1]] = SIMBOL_COCO;
        }

        // Situam els murs en una casella buida
        for (int i = 0; i < NMURS; i++) {
            do {
                pos = UtilitatsArrays.generaArray(2, 0, NTAULER - 1);
            } while (tauler[pos[0]][pos[1]] != SIMBOL_BUIT);

            tauler[pos[0]][pos[1]] = SIMBOL_MUR;
        }
        
        // Situam els Fantasmes en una casella buida
        for (int i = 0; i < NFANTASMES; i++) {
            do {
                pos = UtilitatsArrays.generaArray(2, 0, NTAULER - 1);
            } while (tauler[pos[0]][pos[1]] != SIMBOL_BUIT);

            tauler[pos[0]][pos[1]] = SIMBOL_FANTASME;
        }
        
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
        
        // Calcula la nova posició de pacman
        int[] novaPos = {pacman[0], pacman[1]};
        
        switch (accio) {
            case 4 -> novaPos[1] = (novaPos[1] == 0 ? NTAULER - 1 : novaPos[1] - 1); // ESQUERRA
            case 6 -> novaPos[1] = (novaPos[1] == NTAULER - 1 ? 0 : novaPos[1] + 1); // DRETA
            case 8 -> novaPos[0] = (novaPos[0] == 0 ? NTAULER - 1 : novaPos[0] - 1); // ALT
            case 2 -> novaPos[0] = (novaPos[0] == NTAULER - 1 ? 0 : novaPos[0] + 1); // BAIX
        }
        
        // Si la nova posició és un mur, no ens movem
        if (tauler[novaPos[0]][novaPos[1]] == SIMBOL_MUR)
            return false;

        // Comprovam si hem trobat un fantasma
        if (tauler[novaPos[0]][novaPos[1]] == SIMBOL_FANTASME)
            return true;

        // Si hem trobat un coco, el descomptam
        if (tauler[novaPos[0]][novaPos[1]] == SIMBOL_COCO)
            NCOCOS--;

        // Actualitzam el moviment del pacman
        tauler[pacman[0]][pacman[1]] = SIMBOL_BUIT;
        pacman[0] = novaPos[0];
        pacman[1] = novaPos[1];
        tauler[pacman[0]][pacman[1]] = SIMBOL_PACMAN;

        return false;
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
                    case SIMBOL_CRASH -> car = " X ";
                    case SIMBOL_COCO -> car = " * ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
}