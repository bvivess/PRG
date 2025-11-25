package ACT4_4;
import java.util.ArrayList;
import ACT4_1.UtilitatsArrays;

/**
 *
 * @author T.Vives
 */
public class ACT4_4_06 {

    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(25, 0, 3);
        ArrayList<Integer> resultat = new ArrayList<>();
        
        UtilitatsArrays.mostraArray(array);
        resultat = UtilitatsClasses.mostraDiferentsMillorat(array);
        UtilitatsClasses.mostraArrayListInt(resultat);
    }
}
