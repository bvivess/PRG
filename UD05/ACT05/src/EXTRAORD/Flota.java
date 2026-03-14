package EXTRAORD;

import java.util.ArrayList;

class Flota implements GestioVehicles, GestioConductors {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Conductor> conductors;

    public Flota() {
        this.vehicles = new ArrayList<>();
        this.conductors = new ArrayList<>();
    }
    
    public ArrayList<Vehicle> gestionaManteniment() {
        ArrayList<Vehicle> llista = new ArrayList<>();
        
        for (Vehicle v : this.vehicles)
            if (v.necessitaManteniment())
                llista.add(v);
        
        return llista;
    }

    @Override
    public void afegeixVehicle(Vehicle v) {
        if (this.vehicles.contains(v))
            System.out.println("Vehicle ja es troba a la llista");
        else
            this.vehicles.add(v);
    }

    @Override
    public void afegeixConductor(Conductor c) {
        if (this.conductors.contains(c))
            System.out.println("Conductor ja es troba a la llista");
        else
            this.conductors.add(c); 
    }
    
    @Override
    public Vehicle cercaVehicle(String matricula) {
        for (Vehicle v : this.vehicles) {
            if (v.matricula.equals(matricula)) {
                return v;
            }
        }
        return null;
    }
    
    @Override
    public Conductor cercaConductor(String nom) {
        for (Conductor c : conductors) {
            if (c.nom.equals(nom)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String text = "Flota {";
        
        // Vehicles
        for (Vehicle v : this.vehicles) {
            text = text + "\n Vehicles: " +  v.toString();
        }
        text = text + "\n";
        // Conductors
        for (Conductor c : this.conductors) {
            text = text + "\n Conductors: " +  c.toString();
        }
        
        return  text + "\n}";
    }
    
}