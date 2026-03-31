package ACT10_4;

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
        
        if (this.llibresDisponibles.add(nouLlibre)) {
            if (!titolsDisponibles.containsKey(titol)) {  // si el llibre no es troba
                this.titolsDisponibles.put(titol, new ArrayList<>());
            }
            this.titolsDisponibles.get(titol).add(nouLlibre);  // afegeix el 'llibre' a la llista de títols
        }
    }
    
    /** cercaLlibre: per titol (String)
     *    ha de cercar el llibre en el 'Set' llibresDisponible' 
     *    si no cal cercar el llibre en la 'Queue' llibresPrestat'
     */    
    private Llibre cercaLlibre(String titol) {  // cerca en 'Set' / 'Queue'
        Llibre llibre = cercaLlibreDisponible(titol);
        return (llibre != null) ? llibre : cercaLlibrePrestat(titol);
    }

    private Llibre cercaLlibreDisponible(String titol) {  // cercar en 'Set'
        for (Llibre llibre : this.llibresDisponibles)
            if (llibre.getTitol().equals(titol))
                return llibre;
        return null;
    }
    
    private Llibre cercaLlibrePrestat(String titol) {  // cercar en 'Queue'
        for (Llibre llibre : this.llibresPrestats)
            if (llibre.getTitol().equals(titol))
                return llibre;
        return null;
    }

    public void prestaLlibre(String titol) {
        Llibre llibrePerPrestar = cercaLlibreDisponible(titol);
        if ( llibrePerPrestar != null) {
            this.llibresDisponibles.remove(llibrePerPrestar);  // treure llibre de 'llibresDisponibles'
            this.llibresPrestats.offer(llibrePerPrestar);  // afegir llibre a 'llibresPrestats'
        }
    }

    public void tornaLlibre() {
        Llibre llibreRetornat = this.llibresPrestats.poll();  // treure llibre de 'llibresPrestats'
        if (llibreRetornat != null) {
            this.llibresDisponibles.add(llibreRetornat);  // afegir llibre de 'llibresDisponibles'
        }
    }
    
    public void mostraLlibresDisponibles() {
        System.out.println("Llibres disponibles:");
        for (Llibre llibre : this.llibresDisponibles) {
            System.out.println(llibre.toString());
        }
    }
    
    public void mostraTitolsDisponibles() {
        System.out.println("Títols Disponibles:");
        for (Map.Entry<String, List<Llibre>> e : this.titolsDisponibles.entrySet()) {  // per a cada títol
            System.out.println(e.getKey());
            for (Llibre l : e.getValue())  // per a cada llibre
                System.out.println("\t" + l.toString());
        }
    }

    public void mostraLlibresPrestats() {
        System.out.println("Llibres prestats:");
        for (Llibre llibre : this.llibresPrestats) {
            System.out.println(llibre.toString());
        }
    }
    
    public boolean afegeixAnomalia(int idLlibre, Anomalia anomalia) {
        Llibre llibre = cercaLlibre(idLlibre);  // cerca en 'Set' / 'Queue'

        if (llibre != null)
            return llibre.afegeixAnomalia(anomalia);
        return false;
    }
  
    public boolean eliminaAnomalia(int idLlibre, Anomalia anomalia) {
        Llibre llibre = cercaLlibre(idLlibre);  // cerca en 'Set' / 'Queue'

        if (llibre != null)
            return llibre.eliminaAnomalia(anomalia);
        return false;
    }

    /** cercaLlibre: per idLlibre (int)
     *    ha de cercar el llibre en el 'Set' llibresDisponible' 
     *    si no cal cercar el llibre en la 'Queue' llibresPrestat'
     */    
    private Llibre cercaLlibre(int idLlibre) {  // cerca en 'Set' / 'Queue'
        Llibre llibre = cercaLlibreDisponible(idLlibre);
        return (llibre != null) ? llibre : cercaLlibrePrestat(idLlibre);
    }
    
    private Llibre cercaLlibreDisponible(int idLlibre) {  // cercar en 'Set'
        for (Llibre llibre : this.llibresDisponibles)
            if (llibre.getIdLlibre() == idLlibre)
                return llibre;
        return null;
    }
    
    private Llibre cercaLlibrePrestat(int idLlibre) {  // cercar en 'Queue'
        for (Llibre llibre : this.llibresPrestats)
            if (llibre.getIdLlibre() == idLlibre)
                return llibre;
        return null;
    }
}
