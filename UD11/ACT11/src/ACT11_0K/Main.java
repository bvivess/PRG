package ACT11_0K;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        DiaSetmana[] dies = DiaSetmana.values();  // Transformaci� 1
        List<DiaSetmana> llistaDies = Arrays.asList(dies);  // Transformaci� 2
        Iterator<DiaSetmana> iterator = llistaDies.iterator();
        while (iterator.hasNext()) {
            DiaSetmana dia = iterator.next();
            System.out.println(dia.getAbreviacio() + " " + dia);
            //iterator.remove();
        }
    }

}
