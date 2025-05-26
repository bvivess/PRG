package ex_final;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GestorCentre implements Serializable {
    private Set<Usuari> usuaris = new HashSet<>();
    private Map<String, Activitat> activitats = new HashMap<>();
    private List<Reserva> reserves = new ArrayList<>();

    public void afegirUsuari(Usuari u) {
        usuaris.add(u);
    }
    
    public void mostrarUsuaris() {
        this.getUsuaris().forEach(System.out::println);
    }
    
    public void afegirActivitat(Activitat a) {
        activitats.put(a.getCodi(), a);
    }

    public boolean afegirReserva(String correuUsuari, String codiActivitat, LocalDate data) {
        Usuari u = usuaris.stream().filter(x -> x.getCorreu().equals(correuUsuari)).findFirst().orElse(null);
        Activitat a = activitats.get(codiActivitat);
        if (u == null || a == null) return false;

        Reserva nova = new Reserva(u, a, data);
        if (reserves.contains(nova)) return false;

        reserves.add(nova);
        return true;
    }

    public List<Activitat> activitatsPerDificultat(Dificultat d) {
        return activitats.values().stream()
                .filter(a -> a.getDificultat() == d)
                .collect(Collectors.toList());
    }

    public Map<Activitat, Long> comptarReservesPerActivitat() {
        return reserves.stream()
                .collect(Collectors.groupingBy(Reserva::getActivitat, Collectors.counting()));
    }

    public List<Usuari> usuarisOrdenatsPerReserves() {
        return usuaris.stream()
                .sorted(Comparator.comparingLong(u -> reserves.stream()
                        .filter(r -> r.getUsuari().equals(u))
                        .count()).reversed())
                .collect(Collectors.toList());
    }

    public List<Reserva> filtrarReserves(Predicate<Reserva> criteri) {
        return reserves.stream().filter(criteri).collect(Collectors.toList());
    }

    // Getters per persistència
    public Set<Usuari> getUsuaris() { return usuaris; }
    public Map<String, Activitat> getActivitats() { return activitats; }
    public List<Reserva> getReserves() { return reserves; }
}

