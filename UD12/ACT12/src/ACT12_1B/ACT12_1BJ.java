package ACT12_1B;

import java.util.*;

public class ACT12_1BJ {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList( new Persona("Juan", 1),
                                                new Persona("Jordi",2),
                                                new Persona("Joan", 3),
                                                new Persona("Pere", 4),
                                                new Persona("Maria", 5),
                                                new Persona("Joaquim", 6),
                                                new Persona("Jaume", 7),
                                                new Persona("Judith", 8) );

        

        System.out.println("Llista: " + persones);
        System.out.println(cercaPersona(persones, "Joan")); // Mostrar el resultat
    }
    
    private static Persona cercaPersona(List<Persona> persones, String nom) {
        return persones.stream()
                       .filter(p -> p.getNom().equals(nom)) // Filtrar per nom
                       .findFirst()  // també '.findAny()'
                       .orElse(null); // Recollir el valor 'null'
        
    }
}

