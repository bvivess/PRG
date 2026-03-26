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
    private Set<Vehicle> vehicles;
    private Queue<Vehicle> cuaRecepcio;
    private Map<EstatReparacio, List<Vehicle>> vehiclesPerEstat;
    private List<Vehicle> historics;

    public Taller() {
        vehicles = new HashSet<>();
        cuaRecepcio = new LinkedList<>();
        vehiclesPerEstat = new HashMap<>();
        historics = new ArrayList<>();
        // Inicialitza les llistes del Map per a cada estat
        for (EstatReparacio e : EstatReparacio.values()) {
            vehiclesPerEstat.put(e, new ArrayList<>());
        }
    }

    // Registra un vehicle
    public void registraVehicle(String matricula, String marca, String model, int any) {
        Vehicle v = new Vehicle(matricula, marca, model, any);

        // Només afegim si no existeix ja al Set
        if (vehicles.add(v)) {
            // 1?? Afegim a la cua de recepció
            cuaRecepcio.add(v);

            // 2?? Afegim a la llista del seu estat dins el Map
            List<Vehicle> llista = vehiclesPerEstat.get(v.getEstat());
            llista.add(v);

            System.out.println("Vehicle registrat: " + v);
        } else {
            System.out.println("El vehicle ja està registrat: " + matricula);
        }
    }

    // Inicia diagnòstic del primer vehicle a la cua
    public void iniciaDiagnostic() {
        Vehicle v = cuaRecepcio.poll();
        if (v != null) {
            // Treure de la llista antiga
            List<Vehicle> antigaLlista = vehiclesPerEstat.get(v.getEstat());
            antigaLlista.remove(v);

            // Canviar l'estat
            v.setEstat(EstatReparacio.EN_DIAGNOSTIC);

            // Afegir a la nova llista
            List<Vehicle> novaLlista = vehiclesPerEstat.get(v.getEstat());
            novaLlista.add(v);

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
            List<Vehicle> llistaActual = vehiclesPerEstat.get(v.getEstat());
            llistaActual.remove(v);

            // Canviar l'estat
            v.setEstat(EstatReparacio.EN_REPARACIO);

            // Afegir a la nova llista
            List<Vehicle> llistaNova = vehiclesPerEstat.get(v.getEstat());
            llistaNova.add(v);

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
            List<Vehicle> llistaActual = vehiclesPerEstat.get(v.getEstat());
            llistaActual.remove(v);

            // Canviar l'estat
            v.setEstat(EstatReparacio.REPARAT);

            // Afegir a la nova llista
            List<Vehicle> llistaNova = vehiclesPerEstat.get(v.getEstat());
            llistaNova.add(v);

            // Afegir a l'històric
            historics.add(v);

            System.out.println("Vehicle reparat: " + v);
        } else {
            System.out.println("El vehicle no està en reparació o no existeix: " + matricula);
        }
    }

    // Cerca vehicle per matrícula
    public Vehicle cercaVehicle(String matricula) {
        for (Vehicle v : vehicles) {
            if (v.getMatricula().equals(matricula)) return v;
        }
        return null;
    }

    // Retorna vehicles per estat
    public List<Vehicle> cercaVehiclesPerEstat(EstatReparacio estat) {
        return vehiclesPerEstat.get(estat);
    }

    // Mostra tots els vehicles registrats
    public void mostraVehiclesRegistrats() {
        System.out.println("=== Vehicles registrats ===");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    // Mostra la cua de recepció
    public void mostraCuaRecepcio() {
        System.out.println("=== Cua de recepció ===");
        for (Vehicle v : cuaRecepcio) {
            System.out.println(v);
        }
    }

    // Mostra vehicles agrupats per estat
    public void mostraVehiclesPerEstat() {
        System.out.println("=== Vehicles per estat ===");
        for (EstatReparacio e : EstatReparacio.values()) {
            System.out.println(e + ": " + vehiclesPerEstat.get(e));
        }
    }

    // Mostra històric de reparats
    public void mostraHistorics() {
        System.out.println("=== Vehicles reparats ===");
        for (Vehicle v : historics) {
            System.out.println(v);
        }
    }
}