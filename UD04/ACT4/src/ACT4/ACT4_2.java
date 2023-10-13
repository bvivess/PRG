package ACT4;

/**
 * Crea una classe amb un mètode que rebi un array de sencers i torni la suma de tots els seus valors.
 * Al main mostra aquest resultat.
 */

public class ACT4_2 {
    
    public static void main(String[] args) {
        int[] array = {12, 25, 5, 30, 12};
        
        UtilitatsArrays.mostraArray(array);
        System.out.println("Suma: " + UtilitatsArrays.sumaArray(array));
    }
}