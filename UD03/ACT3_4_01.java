import java.util.Scanner;

public class ACT3_4_02 {
/**
 *
 * @author Tomeu Vives
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total, min, max, suma = 0;
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

        // Mostra la matriu y calcula el min, max i mitjana

        max = matriu[0][0];
        min = matriu[0][0];
        for (int[] array : matriu)
			for (int valor : array) {
				suma += valor;
				if (valor > max)
					max = valor;

				if (valor < min)
					min = valor;
			}

        mitjana = (double) suma / total;

        //System.out.println("[ ");
        for (int[] array : matriu) {
			for (int valor : array)
				System.out.print(valor + " ");
			System.out.println();
        }
		//System.out.println("]");
        
		System.out.println("Màxim: " + max);
        System.out.println("Mínim: " + min);
        System.out.println("Mitjana: " + mitjana);

        scanner.close();
    }
}
