import java.util.Scanner;

/**
 * ACT3.10: Calcular la potencia d'un numero
 *
 * @author Tomeu Vives
 */

public class ACT3_1_10{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int base, exponente, resultado = 1;
		//
		System.out.print("Introduzca la base: ");
		base = scanner.nextInt();
		System.out.print("Introduzca el exponente: ");
		exponente = scanner.nextInt();
		//
		for (int i=1; i<=exponente; i++) {
			resultado = resultado * base;
		}
		System.out.print("El resultado es: " + resultado);
		scanner.close();
	}
}
