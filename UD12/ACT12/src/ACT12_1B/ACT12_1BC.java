package ACT12_1B;

import java.util.*;

public class ACT12_1BC {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList( new Persona("Juan", 30),
                                                new Persona("Jordi",31),
                                                new Persona("Joan", 26),
                                                new Persona("Pere", 24),
                                                new Persona("Maria", 18),
                                                new Persona("Joaquim", 13),
                                                new Persona("Jaume", 26),
                                                new Persona("Judith", 10) );


        Long total = persones.stream()
                             .filter(p->p.getNom().contains("a") && p.getEdat()>5)
                             .count();
        
        System.out.println(total);
        
    }
}
