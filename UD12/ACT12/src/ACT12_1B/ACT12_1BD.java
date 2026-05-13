package ACT12_1B;

import java.util.*;
import java.util.stream.*;

public class ACT12_1BD {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList( new Persona("Juan", 30),
                                                new Persona("Jordi",31),
                                                new Persona("Joan", 26),
                                                new Persona("Pere", 24),
                                                new Persona("Maria", 18),
                                                new Persona("Joaquim", 13),
                                                new Persona("Jaume", 26),
                                                new Persona("Judith", 10) );



        List<Persona> menorsEdat = persones.stream()
                                          .filter(p -> p.getEdat() < 18) // Filtrar només els números positius
                                          .sorted((p1,p2) -> Integer.compare( p1.getEdat(),p2.getEdat()))
                                          .collect(Collectors.toList()); // Recollir en una llista

        double suma = persones.stream().map(p->p.getEdat()).mapToDouble(e->e).sum();
        int max = persones.stream().map(p->p.getEdat()).mapToInt(e->e).max().orElse(0);
        int min = persones.stream().map(p->p.getEdat()).mapToInt(e->e).min().orElse(0);
        double avg = persones.stream().map(p->p.getEdat()).mapToInt(e->e).average().orElse(0);

        System.out.println("Menors d'edat: " + menorsEdat);
        System.out.println("Suma / M?xim / M�nim / Mitjana: " + suma + " / " + max + " / " + min + " / " + avg);
    }
}

