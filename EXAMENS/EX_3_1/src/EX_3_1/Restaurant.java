package EX_3_1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
//import java.util.*;

public class Restaurant {
    private Set<Comanda> comandesRegistrades;
    private ArrayQueueMax<Comanda> cuaCuina;
    private Map<EstatComanda, List<Comanda>> comandesPerEstat;
    private List<Comanda> historics;

    public Restaurant() {
        this.comandesRegistrades = new HashSet<>();
        this.cuaCuina = new ArrayQueueMax<>(3);
        this.comandesPerEstat = new HashMap<>();
        this.historics = new ArrayList<>();

        for (EstatComanda e : EstatComanda.values()) {
            comandesPerEstat.put(e, new ArrayList<>());
        }
    }

    // Registra comanda
    public boolean registraComanda(int id, String nomClient, int taula, LocalDateTime timestamp, List<Plat> plats) {
        Comanda c = new Comanda(id, nomClient, taula, timestamp, plats);  // estat: PENDENT

        if (this.comandesRegistrades.add(c))
            // Afegir a cua
            if (this.cuaCuina.offer(c)) {
                // Afegir al Map
                return this.comandesPerEstat.get(c.getEstat()).add(c);
            } else 
                return false;
        else
            return false;
    }

    // Inicia preparació
    public boolean iniciaPreparacio() {  // estat: EN_PREPARACIO
        Comanda c = cuaCuina.poll();
        
        if (c != null)
            return canviaEstatComanda(c, EstatComanda.EN_PREPARACIO);
        else
            return false;
    }

    // Serveix comanda
    public boolean serveixComanda(int id) {  // estat: SERVIDA
        Comanda c = cercaComanda(id);

        if (c != null && 
            c.getEstat() == EstatComanda.EN_PREPARACIO) {
            return canviaEstatComanda(c, EstatComanda.SERVIDA);
        } else {
            return false;
        }
    }

    // Cobra comanda
    public boolean cobraComanda(int id) {  // estat: COBRADA
        Comanda c = cercaComanda(id);

        if (c != null && c.getEstat() == EstatComanda.SERVIDA)
            if (canviaEstatComanda(c, EstatComanda.COBRADA))
                return historics.add(c);
            else
                return false;
        else
            return false;
    }
    
    private boolean canviaEstatComanda(Comanda c, EstatComanda nouEstat) {
        // 1. Treure de la llista antiga
        List<Comanda> llistaAntiga = this.comandesPerEstat.get(c.getEstat());
        if (llistaAntiga != null) {
            llistaAntiga.remove(c);
        }

        // 2. Canviar estat
        c.setEstat(nouEstat);

        // 3. Afegir a la nova llista
        List<Comanda> llistaNova = this.comandesPerEstat.get(nouEstat);
        return llistaNova != null && llistaNova.add(c);
    }

    // Cerca comanda
    public Comanda cercaComanda(int id) {  // cerca en 'Set'
        for (Comanda c : this.comandesRegistrades) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }
    
    public Comanda cercaComandaHistorics(int id) {  // cerca en 'List'
        int i = this.historics.indexOf(new Comanda(id));
        return (i != -1 ) ? this.historics.get(i) : null;
    }
    
    public List<Comanda> cercaComandesPerEstat(EstatComanda estat) {  // cerca en 'Map'
        return this.comandesPerEstat.get(estat);  // retorna una llista
    }

    // Mostra comandes registrades
    public void mostraComandesRegistrades() {
        Set<Comanda> ordenat = new TreeSet<>(comandesRegistrades);
        for (Comanda c : ordenat) {
            System.out.println(c);
        }
    }

    // Mostra cua (FIFO real)
    public void mostraCuaCuina() {
        for (Comanda c : cuaCuina) {
            System.out.println(c);
        }
    }

    // Mostra per estat
    public void mostraComandesPerEstat() {
        for (Map.Entry<EstatComanda, List<Comanda>> entry : comandesPerEstat.entrySet()) {

            System.out.println(entry.getKey().getDescripcio() + ":");

            List<Comanda> llistaOrdenada = new ArrayList<>(entry.getValue());  // valor del Map
            Collections.sort(llistaOrdenada);

            for (Comanda c : llistaOrdenada) {
                System.out.println("\t" + c);
            }
        }
    }

    // Mostra històric
    public void mostraHistorics() {
        Collections.sort(historics);
        for (Comanda c : historics) {
            System.out.println(c);
        }
    }
}

