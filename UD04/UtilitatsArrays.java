package ACT4;

import java.util.Scanner;

/**
 * @author joan
 */
public class UtilitatsArrays {
    /**
     * Mostra l'array de sencers que rep com a paràmetre per pantalla
     *
     * @param valors L'array que conté els valors que volem mostrar per pantalla.
     */
    public static void mostraArray(int[] valors) {
        String separador = "";
        System.out.print('[');
		
        for (int i = 0; i < valors.length; i++) {
            System.out.print(separador + valors[i]);
            separador = ", ";
        }
        System.out.println(']');
        System.out.println();
    }

    /**
     * Mostra l'array de double que rep com a paràmetre per pantalla
     *
     * @param valors L'array que conté els valors que volem mostrar per pantalla.
     */
    public static void mostraArray(boolean[] valors) {
        String separador = "";
        System.out.print('[');

        for (int i = 0; i < valors.length; i++) {
            System.out.print(separador + valors[i]);
            separador = ", ";
        }
        System.out.println(']');
        System.out.println();
    }

    /**
     * Mostra l'array de double que rep com a paràmetre per pantalla
     *
     * @param valors L'array que conté els valors que volem mostrar per pantalla.
     */
    public static void mostraArray(double[] valors) {
        String separador = "";
        System.out.print('[');

        for (int i = 0; i < valors.length; i++) {
            System.out.print(separador + valors[i]);
            separador = ", ";
        }
        System.out.println(']');
        System.out.println();
    }

    /**
     * Mostra l'array de double que rep com a paràmetre per pantalla
     *
     * @param valors L'array que conté els valors que volem mostrar per pantalla.
     */
    public static void mostraArray(String[] valors) {
        String separador = "";
        System.out.print('[');

        for (int i = 0; i < valors.length; i++) {
            System.out.print(separador + valors[i]);
            separador = ", ";
        }
        System.out.println(']');
        System.out.println();
    }

}
