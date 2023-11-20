package ACT4_5;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;


public class ACT4_5_6 {
    public static void main(String[] args) {
        int[] array = UtilitatsRecOrdCerca.ordenarArrayBimbolla(UtilitatsArrays.generaArray(10,1,100));
        int num, posicio;
        
        UtilitatsArrays.mostraArray(array);
        num = UtilitatsConsola.llegirSencer("Introdueixi un númnero a cercar: ");
        posicio = UtilitatsRecOrdCerca.cercarArray( array, num);
        
        if (posicio != -1 ) {
            System.out.println("S'ha trobat el número en la posició " + posicio);
        } else {
            System.out.println("No s'ha trobat el número " + num);    
        }
    }
}