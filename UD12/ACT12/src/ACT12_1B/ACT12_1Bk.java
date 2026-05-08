package ACT12_1B;

import java.util.*;
import java.util.stream.Collectors;

public class ACT12_1BK {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList( new Persona("Juan", 1),
                                                new Persona("Jordi",2),
                                                new Persona("Joan", 3),
                                                new Persona("Pere", 4),
                                                new Persona("Maria", 5),
                                                new Persona("Joaquim", 6),
                                                new Persona("Jaume", 7),
                                                new Persona("Judith", 8),
                                                new Persona("Joan", 9) );

        

        System.out.println("Llista: " + persones);
        System.out.println(cercaPersona(persones, "Joan")); // Mostrar el resultat
    }
    
    private static List<Persona> cercaPersona(List<Persona> persones, String nom) {
        return persones.stream()
                       .filter(p -> p.getNom().equals(nom)) // Filtrar per nom
                       .collect(Collectors.toList());  // passar a llista
        
    }
}

