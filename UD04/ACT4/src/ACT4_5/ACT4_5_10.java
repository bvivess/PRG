package ACT4_5;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;

/**
 * Crea un m�tode anomenat 'CercaArray' dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre 1 array d''int' amb 10 elements ordenats. Empra l'algoritme de la cerca dicot�mica o cerca bin�ria.
 * https://es.khanacademy.org/computing/computer-science/algorithms/binary-search/a/implementing-binary-search-of-an-array
 * 
 * @author T.Vives
 */

public class ACT4_5_10 {
    public static void main(String[] args) {
        // array aleatori ordenat
        int[] array = UtilitatsRecOrdCerca.ordenaArrayBimbolla(UtilitatsArrays.generaArray(10,1,100));
        int num, posicio;
        
        UtilitatsArrays.mostraArray(array);
        num = UtilitatsConsola.llegirSencer("Introdueixi un n�mnero a cercar: ");
        posicio = UtilitatsRecOrdCerca.cercaArray( array, num);
        
        if (posicio != -1 ) {
            System.out.println("S'ha trobat el n�mero en la posici� " + posicio);
        } else {
            System.out.println("No s'ha trobat el n�mero " + num);    
        }
    }
}