import java.util.Scanner;

/**
 * ACT3.2
 *
 * @author Tomeu Vives
 */

public class ACT3_2{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		//
		System.out.print("Introduzca un número: ");
		num = scanner.nextInt();
		//
		if (num == 0) {
			System.out.print("El número es 0");
		} else if (num % 2 == 0 ) {
			System.out.print("El número es par");
		} else {
			System.out.print("El número es impar");
		}
		scanner.close();
	}
}
