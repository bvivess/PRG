package ACT11_0B;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Set<Persona> persones = new HashSet<>();
        persones.add(new Persona("Maria", 25));
        persones.add(new Persona("Joana", 30));
        persones.add(new Persona("Maria", 25));  // No duplicats
        System.out.println(persones.size()); // ? 2
    }
}

