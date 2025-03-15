package ACT11_1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


public class Main {
    public static void main(String[] args) {
        // BICONSUMER
        BiConsumer<String, String> concatenar = (a,b) -> System.out.println(a + " " + b);
        concatenar.accept("Hello","world !!!"); // "Hello world!!!"
        
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "Anna"); names.put(2,"Pere"); names.put(3,"Joan");
        
        names.forEach((k, v)-> { System.out.print("Clau: " + k);
                                 System.out.print(" Valor: " + v);
                                 System.out.print("\n");
                               });
    }
}

