package ACT10_2B;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
    private Map<LocalDate, List<Tasca>> tasques;

    public Agenda() {
        this.tasques = new HashMap<>();  // 'TreeMap' ordena el 'Map' per 'key'
    }
    
    public List<Tasca> cercaDia(LocalDate data) {  // ecrca en Map
        return this.tasques.get(data);  // 'get' és un cerca: torna la referència de la 'List<Tasca>'
                                        // get retorna 'null' en cas de no trobar la 'clau'
    }

    public void afegeixTasca(LocalDate data, LocalTime hora, String titol) {
        List<Tasca> tasquesDeLaDataCercada = cercaDia(data);
        
        if (tasquesDeLaDataCercada == null) {
            tasquesDeLaDataCercada = new ArrayList<>();
            this.tasques.put(data, tasquesDeLaDataCercada);
        }
        tasquesDeLaDataCercada.add(new Tasca(hora, titol));
        /*
        if (!this.tasques.containsKey(data)) {
            this.tasques.put(data, new ArrayList<>());
        }
        this.tasques.get(data).add(new Tasca(hora, titol));
        */
    }

    public void eliminaTasca(LocalDate data, LocalTime hora) {
        List<Tasca> tasquesEnData = cercaDia(data);  // cerca en Map
        
        tasquesEnData.remove(new Tasca(hora));  // elimina en List --> cal crear equals i hashCode en 'Tasca'
        
        if (tasquesEnData.isEmpty())
            this.tasques.remove(data);  // elimina en Map
        /*
        if (tasquesDeLaDataCercada != null) { // if (this.tasques.containsKey(data)) {
            for (Tasca t : tasquesDeLaDataCercada)  // cerca la 'Tasca' per 'hora'
                if (t.getHora().equals(hora)) {
                    tasquesDeLaDataCercada.remove(t);
                    break;
                }
            if (tasquesDeLaDataCercada.isEmpty())
                tasques.remove(data);
        }*/
    }
    
    public Tasca obteTasca(LocalDate data, LocalTime hora) {
        List<Tasca> tasquesEnData = cercaDia(data);
        if (tasquesEnData == null)
            return null;
        else
            return cercaTasca(tasquesEnData, hora);
    }
    
    private Tasca cercaTasca(List<Tasca> tasquesEnData, LocalTime hora) {
        int i = tasquesEnData.indexOf(new Tasca(hora));
        return (i != -1 ) ? tasquesEnData.get(i) : null;
    }

    @Override
    public String toString() {
        String texte = "TASQUES: ";
        for (Map.Entry<LocalDate, List<Tasca>> entry : this.tasques.entrySet()) {
            List<Tasca> tasquesEnDia = this.tasques.get(entry.getKey());
            texte += "\nData: " + entry.getKey();
            for (Tasca tasca : tasquesEnDia) {
                texte += "\n\t [ " + tasca.toString() + "  ]";
            }
        }
        return texte;
    }
}
