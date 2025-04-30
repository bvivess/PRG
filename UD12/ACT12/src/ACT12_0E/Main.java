package ACT12_0E;

import java.util.Arrays;
// import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList(
            new Persona("Marc", 35),
            new Persona("Joan", 25),
            new Persona("Anna", 30)
        );

        // Collections.sort(persones);
        persones.sort(null);  // ordenat per l''ordre natural'
        System.out.println(persones);  // [Persona{nom=Anna, edat=30}, Persona{nom=Joan, edat=25}, Persona{nom=Marc, edat=35}]
        
        // Collections.sort(persones, new ComparadorPersonaPerEdat());
        // persones.sort( new ComparadorPersonaPerEdat() );
        persones.sort( (p1, p2) -> Integer.compare(p1.getEdat(), p2.getEdat()) );  // ordenat segons la Interfície funcional 'Comparator' (o la seva lambda)
        /*
        persones.sort( (Persona p1, Persona p2) -> { int resultat;
                                                     resultat = Integer.compare(p1.getEdat(), p2.getEdat());
                                                     return resultat;
                                                   }
                      );
        */
        System.out.println(persones);  // [Persona{nom=Joan, edat=25}, Persona{nom=Anna, edat=30}, Persona{nom=Marc, edat=35}]
    }
}
