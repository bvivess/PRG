package ACT11_0F;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Predicate
        Predicate<Integer> esParell = n -> n % 2 == 0;
        System.out.println(esParell.test(4));  // true
        
        // Function
        Function<String, Integer> longitud = s -> s.length();
        System.out.println(longitud.apply("Hola")); // 4
        
        Consumer<String> imprimir = s -> System.out.println("Hola, " + s);
        imprimir.accept("Anna"); // Hola, Anna
        
        Supplier<Double> numAleatori = () -> Math.random();
        System.out.println(numAleatori.get());  // Ex: 0.75432
    }
}

