package ACT09_1;

import java.util.Scanner;

/**
 *
 * @author T.Vives
 */
public class ACT09_3A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int posicio;
        
        try {
            System.out.print("Introdueixi la posició de l'array a llegir (0-" + (array.length-1) + "): ");
            posicio = scanner.nextInt();
            
            // mostraArray:
            try {
                System.out.println(array[posicio]);
            } catch (Exception e) {
                System.out.println("Excepción capturada en el 'try interior': " + e.getMessage());
            }
     
        } catch (Exception e) {
            // Captura i maneja l'excepció si l'usuari no introdueix un enter
            System.err.println("Error general en el 'main'");
        } finally {
            System.err.println("Finally en el 'main'");
        }
    }

}

