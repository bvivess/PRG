package ACT4;

/**
 * Escriviu una classe amb un mètode que rebi un array de tres sencers i l'ordeni.
 * Al main mostra l'array abans i després d'ordenar-lo.
 */

public class ACT4_5 {
    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(3,1,100);
        
        UtilitatsArrays.mostraArray(array);
        UtilitatsArrays.ordenaArray(array);
        UtilitatsArrays.mostraArray(array);
    }
}