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
    private final Set<Llibre> llibres;  // Llibres disponibles
    private final Map<String, List<Llibre>> llibresPerTitol;  // Títols disponibles
    private Queue<Llibre> llibresPrestats;  // Llibres prestats

    public Biblioteca() {
        llibres = new HashSet<>();
        llibresPerTitol = new HashMap<>();
        llibresPrestats = new LinkedList<>();
    }

    public void afegeixLlibre(int idLlibre, String titol, String autor, int anyPublicacio) {
        Llibre nouLlibre = new Llibre(idLlibre, titol, autor, anyPublicacio);
        llibres.add(nouLlibre);

        if (!llibresPerTitol.containsKey(titol)) {
            llibresPerTitol.put(titol, new ArrayList<>());
        }
        llibresPerTitol.get(titol).add(nouLlibre);
    }

    public List<Llibre> cercaLlibresPerTitol(String titol) {
        List<Llibre> llibresAmbTitol = new ArrayList<>();
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equals(titol)) {
                llibresAmbTitol.add(llibre);
            }
        }
    return llibresAmbTitol;
}

    public void prestaLlibre(Llibre llibre) {
        llibres.remove(llibre);
        llibresPrestats.offer(llibre);
    }

    public void tornaLlibre() {
        Llibre llibreRetornat = llibresPrestats.poll();
        if (llibreRetornat != null) {
            llibres.add(llibreRetornat);
        }
    }

    public void mostraLlibresDisponibles() {
        System.out.println("Llibres disponibles:");
        for (Llibre llibre : llibres) {
            System.out.println(llibre.toString());
        }
    }

    public void mostraLlibresPrestats() {
        System.out.println("Llibres prestats:");
        for (Llibre llibre : llibresPrestats) {
            System.out.println(llibre.toString());
        }
    }    
}
