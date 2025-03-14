package ACT09_1;

import java.util.Scanner;

/**
 *
 * @author T,Vives
 */
public class ACT09_3B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int posicio;
        
        try {
            System.out.print("Introdueixi la posici� de l'array a llegir (0-" + (array.length-1) + "): ");
            posicio = scanner.nextInt();
            
            mostraArray(array, posicio);
     
        } catch (Exception e) {
            // Captura i maneja l'excepci� si l'usuari no introdueix un enter
            System.err.println("Error general en el 'main': " + e.getMessage());
        } finally {
            System.err.println("Finally en el 'main'");
        }
    }

    public static void mostraArray(int[] array, int posicio)  {
        try {
            System.out.println(array[posicio]);
        } catch (Exception e) {
            System.out.println("Excepci�n capturada en el m�tode 'mostraArray: " + e.getMessage());
            throw new IndexOutOfBoundsException("Es llan�a una 'excepci�' de manera manual");
        }
    }

}

