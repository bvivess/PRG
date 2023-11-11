import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscaminasConPuntuaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del tablero (n): ");
        int n = scanner.nextInt();

        System.out.print("Ingrese la cantidad de minas: ");
        int numMinas = scanner.nextInt();

        char[][] tablero = inicializarTablero(n, numMinas);
        boolean[][] tableroVisible = new boolean[n][n];

        while (true) {
            imprimirTablero(tablero, tableroVisible);

            System.out.print("Ingrese la fila (0 a " + (n - 1) + "): ");
            int fila = scanner.nextInt();

            System.out.print("Ingrese la columna (0 a " + (n - 1) + "): ");
            int columna = scanner.nextInt();

            if (fila < 0 || fila >= n || columna < 0 || columna >= n) {
                System.out.println("Coordenadas fuera de rango. Intenta de nuevo.");
                continue;
            }

            if (tableroVisible[fila][columna]) {
                System.out.println("Esta casilla ya ha sido seleccionada. Intenta de nuevo.");
                continue;
            }

            if (tablero[fila][columna] == 'X') {
                System.out.println("¡Has golpeado una mina! Fin del juego.");
                break;
            }

            destaparCasilla(tablero, tableroVisible, fila, columna);

            if (esGanador(tablero, tableroVisible)) {
                imprimirTablero(tablero, tableroVisible);
                System.out.println("¡Felicidades! Has ganado.");
                break;
            }
        }

        scanner.close();
    }

    private static char[][] inicializarTablero(int n, int numMinas) {
        char[][] tablero = new char[n][n];
        for (char[] fila : tablero) {
            Arrays.fill(fila, ' ');
        }

        Random random = new Random();
        for (int i = 0; i < numMinas; i++) {
            int fila, columna;
            do {
                fila = random.nextInt(n);
                columna = random.nextInt(n);
            } while (tablero[fila][columna] == 'X');
            tablero[fila][columna] = 'X';
        }

        calcularNumeros(tablero);

        return tablero;
    }

    private static void calcularNumeros(char[][] tablero) {
        int n = tablero.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tablero[i][j] != 'X') {
                    int minasCercanas = contarMinasCercanas(tablero, i, j);
                    tablero[i][j] = (char) ('0' + minasCercanas);
                }
            }
        }
    }

    private static int contarMinasCercanas(char[][] tablero, int fila, int columna) {
        int n = tablero.length;
        int contador = 0;

        for (int i = Math.max(0, fila - 1); i <= Math.min(n - 1, fila + 1); i++) {
            for (int j = Math.max(0, columna - 1); j <= Math.min(n - 1, columna + 1); j++) {
                if (tablero[i][j] == 'X') {
                    contador++;
                }
            }
        }

        return contador;
    }

    private static void destaparCasilla(char[][] tablero, boolean[][] tableroVisible, int fila, int columna) {
        int n = tablero.length;

        if (tableroVisible[fila][columna]) {
            return;  // Si la casilla ya está destapada, no hacemos nada
        }

        tableroVisible[fila][columna] = true;  // Marcamos la casilla como destapada

        if (tablero[fila][columna] == '0') {
            // Si la casilla es un espacio vacío ('0'), propagamos la acción a las casillas adyacentes
            for (int i = Math.max(0, fila - 1); i <= Math.min(n - 1, fila + 1); i++) {
                for (int j = Math.max(0, columna - 1); j <= Math.min(n - 1, columna + 1); j++) {
                    destaparCasilla(tablero, tableroVisible, i, j);
                }
            }
        }
    }

    private static boolean esGanador(char[][] tablero, boolean[][] tableroVisible) {
        int n = tablero.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tablero[i][j] != 'X' && !tableroVisible[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void imprimirTablero(char[][] tablero, boolean[][] tableroVisible) {
        int n = tablero.length;

        System.out.println("Tablero:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tableroVisible[i][j]) {
                    if (tablero[i][j] == 'X') {
                        System.out.print(" " + tablero[i][j] + " ");
                    } else {
                        System.out.print(" " + tablero[i][j] + " ");
                    }
                } else {
                    System.out.print(" ■ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
