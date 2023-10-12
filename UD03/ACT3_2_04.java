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
        int num = 0;
        int comptador = 0;
        int suma = 0;
        double mitjana;
		
		Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Entri una nota(-1 per acabar): ");
			num = scanner.nextInt();
            comptador++;
            suma = suma + num;
        } while (num != -1);
		
        //Hem d'eliminar el zero del compte
        comptador --;
        mitjana = (double) suma / (double) comptador;
        System.out.println("La mitjana és = " + mitjana);
		
		scanner.close();
    }
}
