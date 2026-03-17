package ACT10_0E1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Map<String, Persona> mapa = new HashMap<>();
        mapa.put("43044380H", new Persona("Joan", "43044380H", 23));
        mapa.put("18233438V", new Persona("Aina", "18233438V", 25));
        mapa.put("41312060N",  new Persona("Maria", "41312060N", 30));
        
        Persona persona=mapa.get("43044380H"); // Obté el 'valor' de 'clau'= "43044380H"
        System.out.println(persona.toString());
    }
    
}
