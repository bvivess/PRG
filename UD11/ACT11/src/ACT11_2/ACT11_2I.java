package ACT11_2;

import java.util.*;
import java.util.stream.*;

public class ACT11_2I {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, -2, 3, -4, 5);

        boolean capNegatiu = numeros.stream()
            .noneMatch(n -> n < 0); // Comprovar si cap número és negatiu

        List<Integer> resultats = numeros.stream()
            .filter(n -> n > 0) // Filtrar només els números positius
            .map(n -> n * 10) // Multiplicar per 10
            .collect(Collectors.toList()); // Recollir en una llista

        System.out.println("Cap número és negatiu: " + capNegatiu);
        System.out.println("Resultat multiplicat per 10: " + resultats);
    }
}

