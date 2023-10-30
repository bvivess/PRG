package ACT4_5;
import java.util.ArrayList;
import ACT4_1.UtilitatsArrays;

/**
 *
 * @author T.Vives
 */
public class ACT4_5_02 {

    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(10, 0, 2);
        ArrayList<Integer> resultat = new ArrayList<>();

        for (Integer a: array) {
            if (! resultat.contains(a)) 
                resultat.add(a);		
        }

        System.out.print("[ ");
        for (Integer a : resultat) {
            System.out.print(a + " ");
        }
        System.out.print("]");
    }
}