import java.util.Scanner;

/**
 * ACT3.9: Contar les vegades que apareix la seqUencia 'LA'
 *
 * @author Tomeu Vives
 */

public class ACT3_09{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int contarLA = 0;
		char carAct = ' ', carAnt = ' ';
		do {
			System.out.print("Introduzca caracteres, 'X' para salir: ");
			carAct = scanner.next().charAt(0);
			if (carAnt == 'L' & carAct == 'A') {
				contarLA += 1;
			}
			carAnt = carAct;
		} while (carAct != 'X');
		System.out.println("El suma 'LA' es: " + contarLA);
		scanner.close();
	}
}
