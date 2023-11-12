package ACT4_4;
import java.util.ArrayList;
/**
 *
 * @author T.Vives
 */
public class ACT4_4_01 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();

        for (String a: args) {
            array.add(a);			
        }

        UtilitatsClasses.mostrarArrayListStr(array);
    }
}