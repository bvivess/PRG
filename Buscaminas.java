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
           
