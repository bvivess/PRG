import java.util.Scanner;

/**
 * 25. Feis un programa que llegeixi números sencers del teclat fins que
 * l'usuari pitgi un -1. Calculau la mitjana d'aquests números (sense incloure
 * el 0 final).
 *
 * @author Joan Pons i Tugores
 */
public class ACT3_2_04 {

    public static void main(String[] args) {
        int nota = 0;
        int comptador = 0;
        int suma = 0;
        double mitjana;
		
		Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Entri una nota (-1 per acabar): ");
			nota = scanner.nextInt();
			if ((nota >= 0) && (nota<=10)) {
				comptador++;
				suma = suma + nota;
			}
        } while (nota != -1);
		
        mitjana = (double) suma / (double) comptador;
        System.out.println("La mitjana és = " + mitjana);
		
		scanner.close();
    }
}
