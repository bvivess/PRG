import java.util.Scanner;

public class ACT3_4_03 {
/**
 *
 * @author Tomeu Vives
 */
    public static void main(String[] args) {
		final int NALUMNES = 5;
		final int NNOTES = 10;
		final int MIN = 0;
		final int MAX = 10;
        Scanner scanner = new Scanner(System.in);
		String[] alumnes = new String [NALUMNES];
		int[][] notes = new int[NALUMNES][NNOTES];

		// Llegir no alumnes
		for (int i=0; i<alumnes.length; i++) {
			System.out.print("Nom alumne [" + (i+1) + "]: ");
			alumnes[i] = scanner.nextLine();
        }
		
		// Emplenar aleatòriament les notes de cada alumne
		for (int i=0; i<notes.length; i++) {
			for (int j=0; j<notes[i].length; j++) {
				notes[i][j] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
			}
		}

		// Mostrar les notes per cada alumne
		System.out.println("Les notes dels alumnes són: ");
		for (int i=0; i<notes.length; i++) {
			System.out.print(alumnes[i] + ": ");
			for (int j=0; j<notes[i].length; j++) {
				System.out.print(notes[i][j] + " ");
			}
			System.out.println();
        }

        scanner.close();
    }
}
