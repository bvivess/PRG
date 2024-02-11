package PROVA;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(1,"Un");
        mapa.put(2, "Dos");
        mapa.put(3, "Dos");
        String valor = mapa.get(1); // Obté el valor associat a la clau '1'
        System.out.println(valor);
        System.out.println(mapa.size() );

    }
}
