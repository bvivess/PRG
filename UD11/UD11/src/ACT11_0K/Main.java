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
        Dia[] dies = Dia.values();  // Transformació 1
        List<Dia> llistaDies = Arrays.asList(dies);  // Transformació 2
        Iterator<Dia> iterator = llistaDies.iterator();
        while (iterator.hasNext()) {
            Dia dia = iterator.next();
            System.out.println(dia);
            //iterator.remove();
        }
    }

}
