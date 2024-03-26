package ACT11_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author winadmin
 */
public class Biblioteca {
    private Set<Llibre> llibresDisponibles;  // Llibres disponibles
    private Queue<Llibre> llibresPrestats;  // Llibres prestats
    private Map<String, List<Llibre>> titolsDisponibles;  // Títols disponibles

    public Biblioteca() {
        llibresDisponibles = new HashSet<>();
        llibresPrestats    = new LinkedList<>();
        titolsDisponibles  = new HashMap<>();
    }

    public void afegeixLlibre(int idLlibre, String titol, String autor, int anyPublicacio) {
        Llibre nouLlibre = new Llibre(idLlibre, titol, autor, anyPublicacio);
        this.llibresDisponibles.add(nouLlibre);

        if (!titolsDisponibles.containsKey(titol)) {
            this.titolsDisponibles.put(titol, new ArrayList<>());
        }
        this.titolsDisponibles.get(titol).add(nouLlibre);  // afegeix el 'llibre' a la llista de títols
    }

    public Llibre cercaLlibreDisponible(String titol) {
        for (Llibre l : this.llibresDisponibles) {
            if (l.getTitol().equals(titol)) {
                return l;
            }
        }
        return null;
    }

    public void prestaLlibre(String titol) {
        Llibre llibrePerPrestar = cercaLlibreDisponible(titol);
        if ( llibrePerPrestar != null) {
            this.llibresDisponibles.remove(llibrePerPrestar);
            this.llibresPrestats.offer(llibrePerPrestar);
        }
    }

    public void tornaLlibre() {
        Llibre llibreRetornat = llibresPrestats.poll();
        if (llibreRetornat != null) {
            llibresDisponibles.add(llibreRetornat);
        }
    }
    
    public void mostraLlibresDisponibles() {
        System.out.println("Llibres disponibles:");
        for (Llibre llibre : llibresDisponibles) {
            System.out.println(llibre.toString());
        }
    }
    
    public void mostraTitolsDisponibles() {
        System.out.println("Llibres disponibles:");
        for (String titol : titolsDisponibles.keySet() ) {
            System.out.println(titol);
        }
    }

    public void mostraLlibresPrestats() {
        System.out.println("Llibres prestats:");
        for (Llibre llibre : llibresPrestats) {
            System.out.println(llibre.toString());
        }
    }    
}
