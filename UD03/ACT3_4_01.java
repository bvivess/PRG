import java.util.Scanner;

public class ACT3_4_01 {
/**
 *
 * @author Tomeu Vives
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
		int[] array;
		int suma = 0;
        int max = 0;
        int min = 0;
		double mitjana;

        System.out.print("Introduexi el núm elements: ");
        n = scanner.nextInt();
        array = new int[n];

        // Llegim l'array per teclat
        for (int i = 0; i < n; i++) {
            System.out.print("array[" + (i + 1) + "]: ");
            array[i] = scanner.nextInt();
        }

        // Mostra l'array y calcula el min, max i mitjana

        for (int valor : array) {
            suma += valor;
            if (valor > max) {
                max = valor;
            }
            if (valor < min) {
                min = valor;
            }
        }

        mitjana = (double) suma / n;

        System.out.print("[ ");
        for (int valor : array) {
            System.out.print(valor + " ");
        }
		
		System.out.println("]");
        System.out.println("Màxim: " + max);
        System.out.println("Mínim: " + min);
        System.out.println("Mitjana: " + mitjana);

        scanner.close();
    }
}
