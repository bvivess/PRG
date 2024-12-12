package ACT4_5;

import ACT4_1.UtilitatsArrays;

/**
 * Crea un mètode anomenat 'ordenaArrayBimbolla' dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre 1 array d''int' amb 10 elements i l'ha de tornar ordenar. 
 * Empra l'algoritme de la bimbolla (versión 1):
 * https://es.wikipedia.org/wiki/Ordenamiento_de_burbuja
 * 
 * @author T.Vives
 */

public class ACT4_5_09 {
    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(10,1,100), arrayOrdenat;
        
        UtilitatsArrays.mostraArray(array);
        arrayOrdenat = UtilitatsRecOrdCerca.ordenaArrayBimbolla(array);
        UtilitatsArrays.mostraArray(arrayOrdenat);
    }
}