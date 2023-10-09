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
        int[] vector1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Una altra forma de fer-ho
        int[] vector = new int[10];
        for (int index = 0; index < vector.length; index++) {
            vector[index] = index + 1;
        }

        //Mostrar-los per pantalla
        for (int index = 0; index < vector.length; index++) {
            System.out.print(vector[index] + "\t");
        }
        System.out.println();

    }
}
