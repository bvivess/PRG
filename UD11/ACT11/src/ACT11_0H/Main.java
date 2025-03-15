package ACT11_0H;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Function
        Function<String, Integer> longitud = s -> s.length();
        System.out.println(longitud.apply("Hola")); // 4

    }
}

