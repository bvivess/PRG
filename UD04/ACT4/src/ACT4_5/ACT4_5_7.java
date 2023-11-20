package ACT4_5;

import ACT4_1.UtilitatsArrays;


public class ACT4_5_7 {
    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(10,1,100), arrayOrdenat;
        
        UtilitatsArrays.mostraArray(array);
        arrayOrdenat = UtilitatsRecOrdCerca.ordenarArrayBimbolla(array);
        UtilitatsArrays.mostraArray(arrayOrdenat);
    }
}