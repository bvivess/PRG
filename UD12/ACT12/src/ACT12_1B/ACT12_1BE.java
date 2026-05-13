package ACT12_1B;

import java.util.*;

public class ACT12_1BE {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList( new Persona("Juan Martinez", 30),
                                                new Persona("Jordi Fajula", 31),
                                                new Persona("Joan Soler", 26),
                                                new Persona("Pere March", 24),
                                                new Persona("Maria Nadal", 18),
                                                new Persona("Joaquim Piera", 13),
                                                new Persona("Jaume Ros", 26),
                                                new Persona("Judith Valera", 10),
                                                new Persona("Joan Mas", 9) );

        System.out.println("Llista: " + persones);
        System.out.println(cercaPersona(persones, "Joan")); // Mostrar el resultat
    }
    
    private static Persona cercaPersona(List<Persona> persones, String nom) {
        return persones.stream()
                       .filter(p -> p.getNom().contains(nom)) // Filtrar per nom
                       .findFirst()  // també '.findAny()'
                       .orElse(null); // Recollir el valor 'null'
        
    }
}

