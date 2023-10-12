/**
 * 3. Escriviu una classe que generi dos arrays de sencers de la mateixa
 * longitud i els inicialitzi. 1. Comparau-los amb una igualtat v1==v2.
 * Funciona? Escriviu l'explicació per pantalla utilitzant un println. 2.
 * Comparau-los correctament. Utilitzau una variable booleana per a guardar el
 * resultat. Imprimiu un println que ens informi del resultat de la comparació.
 *
 * @author joan
 */
public class ACT3_3_03 {

    public static void main(String[] args) {

        boolean iguals = true;
        int[] array1 = new int[10];
        int[] array2 = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i;
            array2[i] = i;
        }

        if (array1 == array2) {
            System.out.println("Els arrays són iguals");
		} else {
			System.out.println("Els arrays són diferents");
        }
		System.out.println("'array1==array2' compara les referències de cada array, no els contingut, per això sempre seran diferents.");
        
		// Comparam la longitud
        if (array1.length == array2.length) {
            // Comparam el contingut posició a posició
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    iguals = false;
                }
            }
        } else {
            iguals = false;
        }
		
        if (iguals) {
            System.out.println("Els continguts són iguals");
        } else {
            System.out.println("Els continguts són diferents");
        }
    }
}

