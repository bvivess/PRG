package ACT10_0F;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Persona> mapa = new HashMap<>();
        mapa.put("43044380H", new Persona("Maria", "43044380H", 30)); 
        mapa.put("18233438V", new Persona("Joan", "18233438V", 25)); 
        mapa.put("41312060N", new Persona("Pere", "41312060N", 20));
        mapa.put("43044380H", new Persona("M'és igual", "també", 30));  // Clau duplicada, no s'inserta

        // Iteració per 'clau'?'valor': ordenar prèviament 'mapa.keySet()' si cal ordenació
        for (String key : mapa.keySet()) {
            Persona valor = mapa.get(key);
            System.out.println("Clau: " + key + ", Valor: " + valor);
        }

        // Iteració pel 'valor': ordenar 'mapa.values()' si cal ordenació
        for (Persona valor : mapa.values()) {
            System.out.println("Valor: " + valor);
        }
        // Iteració per a cada tupla del 'mapa': mostra les tuples 
        for (Map.Entry<String, Persona> entry : mapa.entrySet()) {
            System.out.println("Clau: " + entry.getKey() + ", Valor: " + entry.getValue().toString());
            }
    }
    
}
