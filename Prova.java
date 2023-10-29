import java.util.*;
public class Prova {

	public static void main(String[] args) {
		ArrayList notes;		// Declaració d'un ArrayList d''Integers'
		notes = new ArrayList();	// Instanciació de l'ArrayList
		
		notes.add(5);					// Inicialització d'un ArrayList
		notes.add("hola");
		notes.add(9.9);


		for (ArrayList nota : notes) {
			System.out.println(nota);
		}

	}
}








