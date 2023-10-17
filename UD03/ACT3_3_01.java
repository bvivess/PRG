package arrays;

import java.io.IOException;

/**
 * 1. Escriu una classe que crei un vector de 10 sencers, els inicialitzi de 1
 * a 10 i els mostri per pantalla.
 *
 * @author Joan Pons i Tugores
 */
public class ACT3_3_01 {

    public static void main(String[] args) throws IOException {
        //Una forma de fer-ho
        // int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Una altra forma de fer-ho
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        //Mostrar-los per pantalla
		System.out.print("[ ");
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("]");

    }
}
