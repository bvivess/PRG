package ACT11_2;

import java.util.*;
import java.util.stream.*;

public class ACT11_2G {
    public static void main(String[] args) {
        List<String> frases = Arrays.asList(
            "Aprenent Java és divertit", 
            "Java és un llenguatge potent", 
            "M'encanta programar en Java", 
            "Java és potent", 
            "Java és fàcil d'aprendre");

        frases.stream()
            .filter(f -> f.contains("Java")) // Filtrar frases que continguin la paraula "Java"
            .distinct() // Eliminar duplicats
            .skip(0) // Saltar cap frase (opcional, afegit per mostrar el funcionament de skip)
            .limit(3) // Mostrar només les primeres 3 frases
            .forEach(System.out::println); // Mostrar les frases resultants
    }
}

