package prova;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Prova {

    public static void main(String[] args) {
        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(1,"Un"); mapa.put(2, "Dos"); mapa.put(3, "Tres");

        // Iteració per 'clau'-'valor'
        for (Integer k : mapa.keySet()) {
            String valor = mapa.get(k);
            System.out.println("Clau: " + k + ", Valor: " + valor);
        }

        // Iteració simplement pel 'valor':
        for (String valor : mapa.values()) {
            System.out.println("Valor: " + valor);
        }
        // Iteració per cada element del 'mapa':
        for (Map.Entry<Integer, String> element : mapa.entrySet()) {
            System.out.println("Clau: " + element.getKey() + " Valor: " + element.getValue());
        }


    }
    
}
