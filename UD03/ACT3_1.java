import java.util.Scanner;
/**
 * ACT3.1
 *
 * @author Tomeu Vives
 */

public class ACT3_1{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1, num2;
		
		System.out.print("Introduzca el primer número: ");
		num1 = scanner.nextInt();
		
		System.out.print("Introduzca el segundo número: ");
		num2 = scanner.nextInt();
		
		if (num1 > num2) {
			System.out.print("El primer número es mayor que el segundo");
		} else if (num1 < num2) {
			System.out.print("El primer número es menor que el segundo");
		} else {
			System.out.print("Los dos numeros son iguales");
		}
		scanner.close();
	}
}
