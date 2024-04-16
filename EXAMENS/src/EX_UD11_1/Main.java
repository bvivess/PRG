package EX_UD11_1;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<LocalDate, Queue<Persona>> agenda = new TreeMap<>();
        Queue<Persona> persones1 = new LinkedList<>();
        persones1.offer(new Persona("Joan",27));
        Queue<Persona> persones2 = new LinkedList<>();
        persones2.offer(new Persona("Maria", 30));
        persones2.offer(new Persona("Pep",31));
        Queue<Persona> persones3 = new LinkedList<>();
        persones3.offer(new Persona("Aina", 36));
        persones3.offer(new Persona("Josep", 39));
        persones3.offer(new Persona("Arnau",51));
        
        // Càrrega de l'agenda
        agenda.put(LocalDate.of(2024, 1, 01), persones1);
        agenda.put(LocalDate.of(2024, 1, 02), persones2);
        agenda.put(LocalDate.of(2024, 1, 03), persones3);

        for (LocalDate k : agenda.keySet()) {
            Queue<Persona> valor = agenda.get(k);
            System.out.println("Clau: " + k + ", Valor: " + valor.toString());
        }
        
        // 1. Del mòdul amb clau='01/01/2024':  'nom' de la 'Persona' primera de la cua
        System.out.println(agenda.get(LocalDate.of(2024, 1, 01)).poll().getNom());
        
        // 2. Del mòdul amb clau='02/01/2024':  'edat' de la 'Persona' primera de la cua
        System.out.println(agenda.get(LocalDate.of(2024, 1, 02)).poll().getEdat());
        
        // 3. Del mòdul amb clau='03/01/2024':  Llista el 'nom' de cada 'Persona' de la cua
        for (Persona p : agenda.get(LocalDate.of(2024, 1, 03))) {
            System.out.println(p.getNom());
        }
        
    }
}

