import java.util.Scanner;

public class ACT3_4_01 {
/**
 *
 * @author Tomeu Vives
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numElements, min, max, total, suma;
		int[][] matriu;
		float mitjana;

		// Llegeix mida de la matriu
        System.out.print("Introduexi el núm elements de la matriu: ");
        numElements = scanner.nextInt();
        matriu = new int[numElements][numElements];

        // Llegeix les dades de la matriu per teclat
        for (int i = 0; i < matriu.length; i++)
			for (int j = 0; j < matriu[0].length; j++) {
				System.out.print("matriu[" + i + "][" + j + "]: ");
				matriu[i][j] = scanner.nextInt();
			}

        // Mostra la matriu 
		System.out.println("La matriu és:");
		for (int[] array : matriu) {
			for (int valor : array) 
				System.out.print( valor + " " );
			System.out.println();
		}
			
		// Calcula el min
        min = matriu[0][0];
        for (int[] array : matriu)
			for (int valor : array)
				if (valor < min )
					min = valor;

				
		// Calcula el max
        max = matriu[0][0];
        for (int[] array : matriu)
			for (int valor : array)
				if (valor > max)
					max = valor;
				
		// Calcula la mitjana
		total = 0; suma = 0;
        for (int[] array : matriu)
			for (int valor : array) {
				suma += valor;
				total++;
			}
        mitjana = (float) suma / total;

		
		// Mostrar resultats
		System.out.println("Els resultats són:");
		System.out.println("\tMàxim: " + max);
        System.out.println("\tMínim: " + min);
        System.out.println("\tMitjana: " + mitjana);

        scanner.close();
    }
}
