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

    public void afegeixTasca(LocalDate data, LocalTime hora, String titol) {
        List<Tasca> tasquesEnData = cercaDia(data);
        if (tasquesEnData == null)
            this.tasques.put(data, new ArrayList<>());
        else
            tasquesEnData.add(new Tasca(hora, titol));
        /*
        if (!this.tasques.containsKey(data)) {
            this.tasques.put(data, new ArrayList<>());
        }
        this.tasques.get(data).add(new Tasca(hora, titol));
        */
    }
    
    public List<Tasca> cercaDia(LocalDate data) {
        return this.tasques.get(data);  // get retorna 'null' en cas de no trobar la 'clau'
    }

    public void eliminaTasca(LocalDate data, LocalTime hora) {
        if (this.tasques.containsKey(data)) {
            List<Tasca> tasquesDeLaDataCercada = this.tasques.get(data);  // 'get' és un cerca: torna la referència de la 'List<Tasca>'
            for (Tasca t : tasquesDeLaDataCercada) {
                if (t.getHora().equals(hora)) {
                    tasquesDeLaDataCercada.remove(t);
                    break;
                }
            }
            if (tasquesDeLaDataCercada.isEmpty()) {
                tasques.remove(data);
            }
        }
    }
    
    public String obteTasca(LocalDate data, LocalTime hora) {
        List<Tasca> tasquesEnData = cercaDia(data);
        String titol = "";
        if (tasquesEnData == null)
            titol = null;
        else {
            for (Tasca t : tasquesEnData) {
                if (t.getHora().equals(hora)) {
                    titol = t.getTitol();
                    break;
                }
            }
        }
        return titol;
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
