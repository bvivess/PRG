package ACT3_1;

import java.util.Scanner;

/**
 * ACT3.3: Mostrar la qualificació d'un estudiant
 *
 * @author Tomeu Vives
 */

public class ACT3_1_03{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int calificacion;
		//
		System.out.print("Introduzca su calificación: ");
		calificacion = scanner.nextInt();
		//
		if (calificacion >= 5) {
			System.out.print("Aprobado");
		} else {
			System.out.print("Suspendido");
		}
		scanner.close();
	}
}
