package ACT4_6;

import ACT4_1.UtilitatsArrays;


public class ACT4_6_4 {
    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(3,1,100);

        UtilitatsArrays.mostraArray(array);
        if (UtilitatsRecOrdCerca.ordenarArray3(array)) {
            UtilitatsArrays.mostraArray(array);
        } else {
            System.out.println("L'array no es pot ordenar");
        }
    }
}