package ACT10_2A;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Agenda {
    Set<Dia> dies;

    // Constructor
    public Agenda() {
        this.dies = new HashSet<>();
    }
    
    public void afegeixDia(LocalDate data, String ... llistaTasques) {
        Dia dia = cercaDia(data);
        
        if ( dia == null) {  // afegir 'atasques' a tasques
            Queue<String> tasques = new LinkedList<>();
            for (String t : llistaTasques)
                // Afegir tasques
                tasques.offer(t);
            this.dies.add( new Dia(data, tasques) );
        } else {
            for (String t : llistaTasques)
                dia.tasques.offer(t);
        }
    }
    
    public Dia cercaDia(LocalDate data) {
        for (Dia d :this.dies) {
            if (d.data.equals(data))  // isEquals()
                return d;
        }
        return null;
    }
    
    public String obteTasca(LocalDate data) {
        Dia dia = cercaDia(data);
        if (dia != null)
            return dia.tasques.poll();
        else
            return null;
    }

}
