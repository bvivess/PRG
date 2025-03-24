package prova;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Prova {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9);

        List<Integer> resultat = numeros.stream()
                                        
                                        .
                                        .filter(n -> n%2==0)
                                        .map(n -> n*2)
                                        .collect(Collectors.toList());
        /*
        List<Integer> resultat = numeros.stream().
                                         filter(n -> n % 2 != 0). // Filtrar nombres imparells
                                         map(n -> n * 2). // Multiplicar per 2
                                         distinct(). // Eliminar duplicats
                                         collect(Collectors.toList()); // Recollir el resultat en una llista
        */
        System.out.println("Llista: " + numeros);
        System.out.println(resultat); // Mostrar el resultat

    }
    
}
