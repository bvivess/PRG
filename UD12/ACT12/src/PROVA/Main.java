package PROVA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList( new Persona("Juan Martinez", 30),
                                                new Persona("Jordi Fajula",31),
                                                new Persona("Joan Soler", 26),
                                                new Persona("Pere March", 24),
                                                new Persona("Maria Nadal", 18),
                                                new Persona("Joaquim Piera", 13),
                                                new Persona("Jaume Ros", 26),
                                                new Persona("Judith Valera", 10),
                                                new Persona("Joan Mas", 9) );
        System.out.println(
        persones.stream()
                .filter(p->p.getEdat()>8)
                .map(p->p.getEdat())
                    .mapToInt(i->i)
                .average()
        );
    }
}
