package ACT4_5;

import ACT4_1.UtilitatsArrays;

/**
 * Crea un mètode anomenat 'ordenaArray3' dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre 1 array d''int' amb 3 elements i l'ha de tornar ordenar.
 * Ha de comprovar que l'array tengui tres posicions i ha de tornar un 'boolean': 
 *   - 'true' si es pot ordenar, 
 *   - 'false' en cas contrari.
 *
 * @author T.Vives
 */

public class ACT4_5_6 {
    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(3,1,100);

        UtilitatsArrays.mostraArray(array);
        if (UtilitatsRecOrdCerca.ordenaArray3(array)) {
            UtilitatsArrays.mostraArray(array);
        } else {
            System.out.println("L'array no es pot ordenar");
        }
    }
}