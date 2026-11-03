package ACT4_5;

import java.util.ArrayList;
import ACT4_1.UtilitatsArrays;

/**
 *
 * @author T.Vives
 */
public class ACT4_5_05 {

    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(10, 0, 9);
        ArrayList<Integer> resultat;
        
        UtilitatsArrays.mostraArray(array);
        
        resultat = UtilitatsClasses.obteParellsOrdenat(array);
        
        UtilitatsClasses.mostraArrayListInt(resultat);
    }
}
