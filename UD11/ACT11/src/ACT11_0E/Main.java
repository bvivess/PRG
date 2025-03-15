package ACT11_0E;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList(
            new Persona("Marc", 35),
            new Persona("Joan", 25),
            new Persona("Anna", 30)
        );

        // Collections.sort(persones, new ComparadorPersonaPerEdat());
        // persones.sort((p1, p2) -> {return Integer.compare(p1.getEdat(), p2.getEdat());});
        persones.sort( (p1, p2) -> Integer.compare(p1.getEdat(), p2.getEdat()) );

        System.out.println(persones);  // [Joan (25), Anna (30), Marc (35)]
    }
}
