import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 25. Feis un programa que llegeixi números sencers del teclat fins que
 * l'usuari pitgi un zero. Calculau la mitjana d'aquests números (sense incloure
 * el 0 final).
 *
 * @author Joan Pons i Tugores
 */
public class ACT3_2_04 {

    /**
     * Llegeix un sencer del teclat i el torna com a resultat. Aquest resultat
     * s'ha d'assignar a qualque variable o s'ha d'utilitzar en qualque
     * expressió Exemple d'utilització: int maxim;
     * maxim=Teclat.llegirSencer("Introdueixi el màxim: ");
     *
     * @param prompt El missatge que volem mostrar a l'usuari per que sàpiga què
     * li estam demanant.
     * @return El sencer que ha teclejat l'usuari.
     */
    public static int llegirSencer(String prompt) {
        boolean correcte = false;

        int sencer = 0;

        //L'objecte teclat representa l'entrada de dades.
        Scanner teclat = new Scanner(System.in);

        //Llegeix un sencer del teclat. Si el que introdueix l'usuari no es pot 
        //convertir a sencer l'avisa de l'errada i torna a demanar el sencer.
        do {
            System.out.print(prompt);
            try {
                sencer = teclat.nextInt();
                correcte = true;

            } catch (InputMismatchException e) {
                System.err.println("Sencer incorrecte.");
                teclat.next();
            }
        } while (correcte == false);
        return sencer;
    }

    public static void main(String[] args) throws IOException {
        int num = 0;
        int comptador = 0;
        int suma = 0;
        double mitjana;

        do {
            num = llegirSencer("Entri una nota(0 per acabar): ");
            comptador++;
            suma = suma + num;
        } while (num != 0);
        //Hem d'eliminar el zero del compte
        comptador --;
        mitjana = (double) suma / (double) comptador;
        System.out.println("Mitjana=" + mitjana);
    }
}
