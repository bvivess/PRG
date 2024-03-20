package ACT11_2B;

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
        tasques = new TreeMap<>();  // 'TreeMap' ordena el 'Map' per 'key'
    }

    public void afegeixTasca(LocalDate data, LocalTime hora, String titol) {
        if (!this.tasques.containsKey(data)) {
            tasques.put(data, new ArrayList<>());
        }
        tasques.get(data).add(new Tasca(hora, titol));
    }

    public void eliminaTasca(LocalDate data, LocalTime hora) {
        if (this.tasques.containsKey(data)) {
            List<Tasca> tasquesEnData = this.tasques.get(data);  // apunta per referència a la 'List<Tasca>'
            for (Tasca t : tasquesEnData) {
                if (t.getHora().equals(hora)) {
                    tasquesEnData.remove(t);
                    break;
                }
            }
            if (tasquesEnData.isEmpty()) {
                tasques.remove(data);
            }
        }
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
