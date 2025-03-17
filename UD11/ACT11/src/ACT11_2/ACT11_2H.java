package ACT11_2;

import java.util.*;
import java.util.stream.*;

public class ACT11_2H {
    public static void main(String[] args) {
        List<String> telefonos = Arrays.asList(
            "123-456-789", 
            "987-654-321", 
            "123-456-789", 
            "555-123-456", 
            "987-654-321");

        telefonos.stream()
            .map(t -> t.replace("-", "")) // Eliminar els guions per obtenir el número en format continu
            .distinct() // Eliminar duplicats
            .forEach(System.out::println); // Mostrar els números de telèfon resultants
    }
}
