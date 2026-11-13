package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

/**
 * Avaluació Arrays i Matrius: Joc del Caçador de Tresors.
 * SIMBOL_BUIT    --> 0 ("   ")
 * SIMBOL_JUGADOR --> 1 (" J ")
 * SIMBOL_MINA    --> 5 (" X ")
 * SIMBOL_TRESOR  --> 9 (" * ")
 */
public class ACT4_6_B {
    static final int NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
    static final int NTRESORS = UtilitatsConsola.llegirSencer("Numero de tresors: ");
    static final int NMINES = UtilitatsConsola.llegirSencer("Numero de mines: ");
    
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_JUGADOR = 1;
    static final int SIMBOL_MINA = 5;
    static final int SIMBOL_TRESOR = 9;

    public static void main(String[] args) {
        int[][] tauler = new int[NTAULER][NTAULER];
        int[] jugador = new int[2]; // posició {fila, columna}
        int accio;
        int tresorsRecollits = 0;
        boolean viu = true;

        // Validació bàsica per evitar bucle infinit si s'omple el tauler
        if (NTRESORS + NMINES >= NTAULER * NTAULER) {
            System.out.println("Error: Massa elements per a la mida del tauler.");
            return;
        }

        inicialitzaJoc(tauler, jugador);

        do {
            System.out.println("\nTresors: " + tresorsRecollits + "/" + NTRESORS);
            UtilitatsArrays.mostraArray(jugador);
            mostraTauler(tauler);

            accio = UtilitatsConsola.llegirSencer("ACCIONS: 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            
            if (accio != 0) {
                int casellaTrepitjada = cambiaPosicio(tauler, jugador, accio);
                
                if (casellaTrepitjada == SIMBOL_TRESOR) {
                    tresorsRecollits++;
                    System.out.println(">> Has trobat un tresor!");
                } else if (casellaTrepitjada == SIMBOL_MINA) {
                    viu = false;
                    System.out.println(">> BOOM! Has trepitjat una mina.");
                }
            }
        } while (accio != 0 && viu && tresorsRecollits < NTRESORS);

        // Resultat final de la partida
        mostraTauler(tauler);
        if (!viu) {
            System.out.println("FI DEL JOC: Has perdut.");
        } else if (tresorsRecollits == NTRESORS) {
            System.out.println("ENHORABONA: Has recollit tots els tresors!");
        } else {
            System.out.println("Has sortit de la partida.");
        }
    }

    public static void inicialitzaJoc(int[][] tauler, int[] jugador) {
        // Posició aleatòria per al jugador
        int[] pos = UtilitatsArrays.generaArray(2, 0, NTAULER - 1);
        jugador[0] = pos[0];
        jugador[1] = pos[1];
        tauler[jugador[0]][jugador[1]] = SIMBOL_JUGADOR;

        // Situam els tresors en caselles buides
        int ntresors = 0;
        while (ntresors < NTRESORS) {
            pos = UtilitatsArrays.generaArray(2, 0, NTAULER - 1);
            if (tauler[pos[0]][pos[1]] == SIMBOL_BUIT) {
                tauler[pos[0]][pos[1]] = SIMBOL_TRESOR;
                ntresors++;
            }
        }

        // Situam les mines en caselles buides
        int nmines = 0;
        while (nmines < NMINES) {
            pos = UtilitatsArrays.generaArray(2, 0, NTAULER - 1);
            if (tauler[pos[0]][pos[1]] == SIMBOL_BUIT) {
                tauler[pos[0]][pos[1]] = SIMBOL_MINA;
                nmines++;
            }
        }
    }

    /**
     * Mou el jugador respectant les parets i retorna el símbol que hi havia
     * a la casella de destí abans d'ocupar-la.
     */
    public static int cambiaPosicio(int[][] tauler, int[] jugador, int accio) {
        // Esborram la posició actual
        tauler[jugador[0]][jugador[1]] = SIMBOL_BUIT;

        // Calculam nova posició comprovant els límits del tauler (parets)
        switch (accio) {
            case 4 -> { // ESQUERRA
                if (jugador[1] > 0) jugador[1]--;
                else System.out.println("Paret esquerra! No et pots moure.");
            }
            case 6 -> { // DRETA
                if (jugador[1] < NTAULER - 1) jugador[1]++;
                else System.out.println("Paret dreta! No et pots moure.");
            }
            case 8 -> { // ALT
                if (jugador[0] > 0) jugador[0]--;
                else System.out.println("Paret superior! No et pots moure.");
            }
            case 2 -> { // BAIX
                if (jugador[0] < NTAULER - 1) jugador[0]++;
                else System.out.println("Paret inferior! No et pots moure.");
            }
            default -> System.out.println("Tecla no vàlida.");
        }

        // Llegim què hi ha a la casella destí ABANS de sobreescriure-la
        int contingutDesti = tauler[jugador[0]][jugador[1]];
        tauler[jugador[0]][jugador[1]] = SIMBOL_JUGADOR;

        return contingutDesti;
    }

    public static void mostraTauler(int[][] tauler) {
        String car = "   ";
        for (int i = 0; i < NTAULER; i++) {
            System.out.print('|');
            for (int j = 0; j < NTAULER; j++) {
                switch (tauler[i][j]) {
                    case SIMBOL_BUIT -> car = "   ";
                    case SIMBOL_JUGADOR -> car = " J ";
                    case SIMBOL_MINA -> car = " X ";
                    case SIMBOL_TRESOR -> car = " * ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
}
