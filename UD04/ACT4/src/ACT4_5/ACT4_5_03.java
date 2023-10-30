package ACT4_5;
import java.util.ArrayList;
import ACT4_1.UtilitatsArrays;

/**
 *
 * @author T.Vives
 */
public class ACT4_5_03 {

    public static void main(String[] args) {
        int i;
        //int[] array = UtilitatsArrays.generaArray(10, 0, 2);
        int[] array = {1,1,2,0,2,1,0};
        ArrayList<Integer> resultat = new ArrayList<>();
        
        resultat.add(array[0]);
        
        for (int a : array) {
            i = 0;
            boolean trobat = false;
            for (Integer r : resultat) {
                System.out.println(a + " -  pos: " + r);
                if (a > r) {
                    i++;
                    break;
                } else if( a == r) {
                    i++;
                    trobat = true;
                    break;
                } else i++;

            }
            if (!trobat) {
                resultat.add(i,a);
                System.out.println("no trobat");
            } else System.out.println("trobat");
        }

        System.out.print("[ ");
        for (Integer a : resultat) {
            System.out.print(a + " ");
        }
        System.out.print("]");
    }
}
