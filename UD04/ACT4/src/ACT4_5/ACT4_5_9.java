package ACT4_5;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;


public class ACT4_5_9 {
    public static void main(String[] args) {
        int[] array = UtilitatsRecOrdCerca.ordenaArrayBimbolla(UtilitatsArrays.generaArray(10,1,100));
        int num, posicio;
        
        UtilitatsArrays.mostraArray(array);
        num = UtilitatsConsola.llegirSencer("Introdueixi un númnero a cercar: ");
        posicio = UtilitatsRecOrdCerca.cercaArrayRecursiu( array, num, 0, array.length - 1 );
        
        if (posicio != -1 ) {
            System.out.println("S'ha trobat el número en la posició " + posicio);
        } else {
            System.out.println("No s'ha trobat el número " + num);    
        }
    }
}