package ACT4_5;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;

/**
 * Crea un mètode anomenat 'CercaArray' dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre 1 array d''int' amb 10 elements ordenats. Empra l'algoritme de la cerca dicotòmica o cerca binària.
 * https://es.khanacademy.org/computing/computer-science/algorithms/binary-search/a/implementing-binary-search-of-an-array
 * 
 * @author T.Vives
 */

public class ACT4_5_8 {
    public static void main(String[] args) {
        // array aleatori ordenat
        int[] array = UtilitatsRecOrdCerca.ordenaArrayBimbolla(UtilitatsArrays.generaArray(10,1,100));
        int num, posicio;
        
        UtilitatsArrays.mostraArray(array);
        num = UtilitatsConsola.llegirSencer("Introdueixi un númnero a cercar: ");
        posicio = UtilitatsRecOrdCerca.cercaArray( array, num);
        
        if (posicio != -1 ) {
            System.out.println("S'ha trobat el número en la posició " + posicio);
        } else {
            System.out.println("No s'ha trobat el número " + num);    
        }
    }
}