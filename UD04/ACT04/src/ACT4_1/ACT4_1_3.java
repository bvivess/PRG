package ACT4_1;

/**
 * Crea una classe amb un mètode que rebi un array de sencers i torni la suma de tots els seus valors.
 * Al main mostra aquest resultat.
 */

public class ACT4_1_3 {
    
    public static void main(String[] args) {
        int[] array = {7, 8, 5, 2, 9};
        
        UtilitatsArrays.mostraArray(array);
        System.out.println("Mitjana: " + UtilitatsArrays.mitjanaArray(array));
    }
}