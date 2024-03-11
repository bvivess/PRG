package ACT11_2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 *
 * @author T.Vives
 */
public class Main {

    public static void main(String[] args) {
        Set<Dia> agenda = new HashSet<>();
        Queue<String> tasques = new LinkedList<>();
        
        // DIA 1/1/2004: Tasca1, Tasca2, Tasca3
        // Afegir un dia a l'agenda
        afegeixDia(agenda, LocalDate.of(2024, 1, 1), "Tasca1","Tasca2","Tasca3");
             
        // DIA 2/1/2004: Tasca1 
        afegeixDia(agenda, LocalDate.of(2024, 1, 2), "Tasca1");
        
        // DIA 2/1/2004: Tasca2, Tasca3 
        afegeixDia(agenda, LocalDate.of(2024, 1, 2), "Tasca2", "Tasca3");
        
        System.out.println(cercaDia(agenda, LocalDate.of(2024, 01, 02)));
    }
    
    public static void afegeixDia(Set<Dia> agenda, LocalDate data, String ... atasques) {
        Queue<String> tasques = new LinkedList<>();
        Dia dia = cercaDia(agenda, data);
        
        if ( dia == null) {  // afegir atasques a tasques
            for (String a:atasques)
                // Afegir tasques
                tasques.offer(a);
            Dia nouDia = new Dia(data, tasques);
            agenda.add( nouDia );
        } else {
            for (String a:atasques)
                dia.tasques.offer(a);
        }
    }
    
    public static Dia cercaDia(Set<Dia> agenda, LocalDate data) {
        for (Dia d :agenda) {
            if (d.data.isEqual(data))
                return d;
        }
        return null;
    }
    
    public static String obteTasca(Set<Dia> agenda, LocalDate data) {
        Dia dia = cercaDia(agenda, data);
        if (dia != null)
            return dia.tasques.poll();
        else
            return null;
    }
    
}
