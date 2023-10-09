package arrays;

//import exercicisResolts2015.*;
//import exercicisResolts.*;

/**
 * 3. Escriviu una classe que generi dos vectors de sencers de la mateixa
 * longitud i els inicialitzi. 1. Comparau-los amb una igualtat v1==v2.
 * Funciona? Escriviu l'explicació per pantalla utilitzant un println. 2.
 * Comparau-los correctament. Utilitzau una variable booleana per a guardar el
 * resultat. Imprimiu un println que ens informi del resultat de la comparació.
 *
 * @author joan
 */
public class ACT3_3_03 {

    public static void main(String[] args) {

        boolean iguals = true;
        int[] vector1 = new int[10];
        int[] vector2 = new int[vector1.length];
        for (int index = 0; index < vector1.length; index++) {
            vector1[index] = index + 1;
            vector2[index] = index + 1;
        }

        if (vector1 == vector2) {
            System.out.println("Són iguals");
        }
        System.out.println("Amb vector1==vector2 comparam les referencies on estan guardats els vectors, i mai seran la mateixa.");
        //Comparam la longitud
        if (vector1.length == vector2.length) {
            //Comparam els vectors posició a posició
            for (int index = 0; index < vector1.length; index++) {
                if (vector1[index] != vector2[index]) {
                    iguals = false;
                }
            }
        } else {
            iguals = false;
        }
        if (iguals) {
            System.out.println("Els continguts són iguals");
        } else {
            System.out.println("Els continguts són diferents");

        }
    }
}
