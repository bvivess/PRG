import java.util.Scanner;

public class ACT3_4_02 {
/**
 * Crea una matriu d''int' 
 * Demana a l'usuari els valors i guarda'ls a la matriu
 * Finalment:
 * demana a l'usuari el valor d'una FILA  i mostra els valors de tota aquesta fila
 * demana a l'usuari el valor d'una COLUMNA  i mostra els valors de tota aquesta columna
 *
 * @author Tomeu Vives
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total, columna, fila;
		int[][] matriu;
		double mitjana;

        System.out.print("Introduexi el núm elements: ");
        total = scanner.nextInt();
        matriu = new int[total][total];

        // Llegim la matriu per teclat
        for (int i = 0; i < matriu.length; i++)
			for (int j = 0; j < matriu[0].length; j++) {
				System.out.print("matriu[" + i + "][" + j + "]: ");
				matriu[i][j] = scanner.nextInt();
			}

        // Mostrar la matriu
        for (int[] array : matriu) {
			for (int valor : array)
				System.out.print(valor + " ");
			System.out.println();
        }
		
		// Mostrar una FILA
        System.out.print("Introduexi la FILA a mostrar: ");
        fila = scanner.nextInt();
        // Mostra la columna i la fila esmentada
        for (int j = 0; j < matriu[0].length; j++)
			System.out.print( matriu[fila][j] + " " );

		System.out.println();

		// Mostrar una COLUMNA
        System.out.print("Introduexi la COLUMNA a mostrar: ");
        columna = scanner.nextInt();
		
        // Mostra la columna i la fila esmentada
        for (int i = 0; i < matriu.length; i++)
			System.out.println( matriu[i][columna] + " " );
		
        scanner.close();
    }
}
