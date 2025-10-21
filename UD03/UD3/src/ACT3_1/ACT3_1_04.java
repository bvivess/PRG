package ACT3_1;

import java.util.Scanner;

/**
 * ACT3.4: Mostrar la qualificació d'un estudiant
 *
 * @author Tomeu Vives
 */

public class ACT3_1_04{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Float calificacion;
		//
		System.out.print("Introduzca su calificación: ");
		calificacion = scanner.nextFloat();
		//
		if (calificacion >= 9) {
			System.out.print("Sobresaliente");
		} else if (calificacion >= 7) {
			System.out.print("Notable");
		} else if (calificacion >= 6) {
			System.out.print("Bien");
		} else if (calificacion >= 5) {
			System.out.print("Aprobado");
		} else if (calificacion >= 3) {
			System.out.print("Insuficiente");
		} else {
			System.out.print("Muy deficiente");
		}
		scanner.close();
	}
}
