package ACT4;

/**
 * Escriviu una classe que generi dos vectors de sencers i els inicialitzi. Escriviu un mètode que pugui rebre dos
 * vectors de sencers de diferent longitud i torni un boolèa dient si són iguals o no.
 * Si no tenen la mateixa longitud evidentment no són iguals.
 */

public class ACT4_4 {
    public static void main(String[] args) {
        // int[]a={1,2,3,4};
        // int[]b={1,2,3};
        int[] a = UtilitatsArrays.generaArray(10,1,100);
        int[] b = UtilitatsArrays.generaArray(10,1,100);

        System.out.print("a: ");
        UtilitatsArrays.mostraArray(a);
        System.out.print("b: ");
        UtilitatsArrays.mostraArray(b);

        System.out.println(UtilitatsArrays.comparaArrays(a, b));
    }
}