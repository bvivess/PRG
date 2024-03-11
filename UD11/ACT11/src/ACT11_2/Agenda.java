package ACT11_2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author winadmin
 */
public class Agenda {
    Set<Dia> dies;

    // Constructor
    public Agenda(Set<Dia> dies) {
        this.dies = dies;
    }
    // es permet el constructor 'default'
    
    public void afegeixDia(LocalDate data, String ... atasques) {
        Queue<String> tasques = new LinkedList<>();
        Dia dia = cercaDia(data);
        
        if ( dia == null) {  // afegir atasques a tasques
            for (String a:atasques)
                // Afegir tasques
                tasques.offer(a);
            Dia nouDia = new Dia(data, tasques);
            this.dies.add( nouDia );
        } else {
            for (String a:atasques)
                dia.tasques.offer(a);
        }
    }
    
    public Dia cercaDia(LocalDate data) {
        for (Dia d :this.dies) {
            if (d.data.isEqual(data))
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
