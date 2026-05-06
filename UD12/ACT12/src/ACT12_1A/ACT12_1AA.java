package ACT12_1A;

import java.util.*;
import java.util.stream.*;

public class ACT12_1AA {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(4, 5, 3, 9, 2, 5, 6, 1, 8, 7);
        
        

        List<Integer> resultat = numeros.stream()
                                        .filter(n -> n % 2 != 0) // Filtrar nombres imparells /5, 3, 9, 5, 1, 7/
                                        .map(n -> n * 2) // Multiplicar per 2   /10, 6, 18, 10, 2, 14/
                                        .distinct() // Eliminar duplicats  /10, 6, 18,  2, 14/
                                        .sorted((x,y)->x.compareTo(y)*(-1))   // Ordenar-los de manera descendent  /18, 14, 10, 6, 2/
                                        .collect(Collectors.toList()); // Recollir el resultat en una llista  (18, 14, 10, 6, 2)

        System.out.println("Llista: " + numeros);
        System.out.println(resultat); // Mostrar el resultat
    }
}

