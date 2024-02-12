package ACT11_0D;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Queue<String> cua = new LinkedList<>();
        cua.offer("Element1");
        cua.offer("Element2");
        System.out.println(cua.poll());  // element ? "Element1"
    }
    
}
