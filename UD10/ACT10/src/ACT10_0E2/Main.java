package ACT10_0E2;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Persona, String> mapa = new HashMap<>();
        mapa.put(new Persona("Joan", "43044380H", 23), "43044380H"); 
        mapa.put(new Persona("Aina", "18233438V", 25), "18233438V");
        mapa.put(new Persona("Maria", "41312060N", 30), "41312060N");

        String dadesMaria = mapa.get(new Persona("Maria", "41312060N", 30));  // ???
        System.out.println(dadesMaria);  // "41312060N"

    }
    
}
