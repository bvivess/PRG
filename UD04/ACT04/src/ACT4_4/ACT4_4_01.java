package ACT4_4;

import java.util.ArrayList;
import ACT4_1.UtilitatsArrays;

/**
 *
 * @author T.Vives
 */
public class ACT4_4_01 {
    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(10, 0, 3);
        ArrayList<Integer> diferents;
        
        UtilitatsArrays.mostraArray(array);
        diferents = UtilitatsClasses.generaDiferents(array);

        UtilitatsClasses.mostraArrayListInt(diferents);
    }
}