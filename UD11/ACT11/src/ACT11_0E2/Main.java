package ACT11_0E2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Map<Persona, String> mapaPersones = new HashMap<>();
        Persona persona1 = new Persona("Maria", 30);  // Persona1
        Persona persona2 = new Persona("Joan", 25);  // Persona2
        mapaPersones.put(persona1, "Dades de Maria");
        mapaPersones.put(persona2, "Datos de Joan");

        String dadesMaria = mapaPersones.get(new Persona("Maria", 30));
        System.out.println(dadesMaria);

    }
    
}
