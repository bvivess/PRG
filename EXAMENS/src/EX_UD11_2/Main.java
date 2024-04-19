package EX_UD11_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Persona>> agenda = new TreeMap<>();
        List<Persona> persones1 = new ArrayList<>();
        persones1.add(new Persona("Joan",27));
        persones1.add(new Persona("Maria", 30));
        List<Persona> persones2 = new ArrayList<>();
        persones2.add(new Persona("Pep",31));
        persones2.add(new Persona("Aina", 36));
        persones2.add(new Persona("Josep", 39));
        List<Persona> persones3 = new ArrayList<>();
        persones3.add(new Persona("Arnau",51));
        persones3.add(new Persona("Bernat",5));
        // Càrrega de l'agenda
        agenda.put("Grup1", persones1);
        agenda.put("Grup2", persones2);
        agenda.put("Grup3", persones3);

        for (String k : agenda.keySet()) {
            List<Persona> valor = agenda.get(k);
            System.out.println("Clau: " + k + ", Valor: " + valor.toString());
        }
        
        // 1. Del grup amb clau='Grup1':  'nom' de la segona 'Persona' de la llista
        System.out.println(agenda.get("Grup1").get(1).getNom());
        
        // 2. Del grup amb clau='Grup2':  'edat' de la tercera 'Persona' de la llista
        System.out.println(agenda.get("Grup2").get(2).getEdat());
        
        // 3. Del grup amb clau='Grup3'::  Llista el 'nom' de cada 'Persona' de la llista
        for (Persona p : agenda.get("Grup3")) {
            System.out.println(p.getNom());
        }
        
    }
}

