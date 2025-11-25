package ACT4_4;
import java.util.ArrayList;
import ACT4_1.UtilitatsArrays;

/**
 *
 * @author T.Vives
 */
public class ACT4_4_08 {

    public static void main(String[] args) {
        int[] array1 = UtilitatsArrays.generaArray(10, 0, 9);
        int[] array2 = UtilitatsArrays.generaArray(10, 0, 9);
        ArrayList<Integer> resultat;
        
        UtilitatsArrays.mostraArray(array1);
        UtilitatsArrays.mostraArray(array2);
        resultat = UtilitatsClasses.obteDiferents(array1, array2);
        UtilitatsClasses.mostraArrayListInt(resultat);
    }
}
