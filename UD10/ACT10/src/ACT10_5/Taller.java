package ACT10_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Classe Taller
class Taller {
    private Set<Vehicle> vehiclesRegistrats;
    private Queue<Vehicle> cuaRecepcio;
    private Map<EstatReparacio, List<Vehicle>> vehiclesPerEstat;
    private List<Vehicle> vehiclesHistorics;

    public Taller() {
        this.vehiclesRegistrats = new HashSet<>();
        this.cuaRecepcio = new LinkedList<>();
        this.vehiclesPerEstat = new HashMap<>();
        this.vehiclesHistorics = new ArrayList<>();
        
        // Inicialitza les llistes del Map per a cada estat
        for (EstatReparacio e : EstatReparacio.values()) {
            this.vehiclesPerEstat.put(e, new ArrayList<>());
        }
    }

    // Registra un vehicle
    public void registraVehicle(String matricula, String marca, String model, int any) {
        Vehicle v = new Vehicle(matricula, marca, model, any);

        // Només afegim si no existeix al Set
        if (this.vehiclesRegistrats.add(v)) {
            // Afegir a la 'cuaRecepcio'
            this.cuaRecepcio.offer(v);

            // Afegir a 'vehiclesPerEstat'
            List<Vehicle> llista = vehiclesPerEstat.get(v.getEstat());  // extreu la 'llista' del 'map'
            llista.add(v);  // modifica la llista
            // vehiclesPerEstat.get(v.getEstat()).add(v);  // Afegir a 'vehiclesPerEstat' directament
            
            System.out.println("Vehicle registrat: " + v);
        } else {
            System.out.println("El vehicle ja està registrat: " + matricula);
        }
    }

    // Inicia diagnòstic del primer vehicle a la cua
    public void iniciaDiagnostic() {
        Vehicle v = this.cuaRecepcio.poll();
        
        if (v != null) {
            // Treure de la llista antiga
            this.vehiclesPerEstat.get(v.getEstat()).remove(v);

            // Canviar l'estat
            v.setEstat(EstatReparacio.EN_DIAGNOSTIC);

            // Afegir a la nova llista
            this.vehiclesPerEstat.get(v.getEstat()).add(v);

            System.out.println("Vehicle en diagnòstic: " + v);
        } else {
            System.out.println("No hi ha vehicles a la recepció.");
        }
    }

    // Envia un vehicle a reparació segons matrícula
    public void enviaAReparacio(String matricula) {
        Vehicle v = cercaVehicle(matricula);
        if (v != null && v.getEstat() == EstatReparacio.EN_DIAGNOSTIC) {
            // Treure de la llista de l'estat actual
            vehiclesPerEstat.get(v.getEstat()).remove(v);

            // Canviar l'estat
            v.setEstat(EstatReparacio.EN_REPARACIO);

            // Afegir a la nova llista
            vehiclesPerEstat.get(v.getEstat()).add(v);

            System.out.println("Vehicle enviat a reparació: " + v);
        } else {
            System.out.println("El vehicle no està en diagnòstic o no existeix: " + matricula);
        }
    }

    // Finalitza reparació
    public void finalitzaReparacio(String matricula) {
        Vehicle v = cercaVehicle(matricula);
        if (v != null && v.getEstat() == EstatReparacio.EN_REPARACIO) {
            // Treure de la llista de l'estat actual
            vehiclesPerEstat.get(v.getEstat()).remove(v);

            // Canviar l'estat
            v.setEstat(EstatReparacio.REPARAT);

            // Afegir a la nova llista
            vehiclesPerEstat.get(v.getEstat()).add(v);

            // Afegir a l'històric
            this.vehiclesHistorics.add(v);

            System.out.println("Vehicle reparat: " + v);
        } else {
            System.out.println("El vehicle no està en reparació o no existeix: " + matricula);
        }
    }

    // Cerca vehicle per matrícula
    public Vehicle cercaVehicle(String matricula) {
        for (Vehicle v : this.vehiclesRegistrats) {
            if (v.getMatricula().equals(matricula))
                return v;
        }
        return null;
    }

    // Retorna vehicles per estat
    public List<Vehicle> cercaVehiclesPerEstat(EstatReparacio estat) {
        return this.vehiclesPerEstat.get(estat);
    }

    // Mostra tots els vehicles registrats
    public void mostraVehiclesRegistrats() {
        System.out.println("=== Vehicles registrats ===");
        for (Vehicle v : this.vehiclesRegistrats)
            System.out.println(v);
    }

    // Mostra la cua de recepció
    public void mostraCuaRecepcio() {
        System.out.println("=== Cua de recepció ===");
        for (Vehicle v : this.cuaRecepcio)
            System.out.println(v);
    }

    // Mostra vehicles agrupats per estat
    public void mostraVehiclesPerEstat() {
        System.out.println("=== Vehicles per estat ===");
        for (EstatReparacio e : EstatReparacio.values()) {
            System.out.println(e + ": " + this.vehiclesPerEstat.get(e).toString());
        }
    }

    // Mostra històric de reparats
    public void mostraHistorics() {
        System.out.println("=== Vehicles reparats ===");
        for (Vehicle v : this.vehiclesHistorics) {
            System.out.println(v);
        }
    }
}