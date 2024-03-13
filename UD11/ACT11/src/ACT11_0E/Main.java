package ACT11_0E;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Map<Integer, String> mapa = new HashMap<>();  // No cal implementar 'hashCode()', 'equals()' d''Integer'
        mapa.put(1,"Un"); // "Clau-valor": 1-"Un"
        mapa.put(2, "Dos");
        mapa.put(3, "Tres");
        Integer clau = 1;
        String valor = mapa.get(clau); // Obté el 'valor' de 'clau' = 1
        System.out.println(valor);
    }
    
}
