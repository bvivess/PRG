package EXTRAORD;

import java.util.ArrayList;

class Conductor extends Persona {
    private String tipus;
    private ArrayList<Vehicle> vehiclesAssignats;

    public Conductor(String nom, int edat, String tipus) {
        super(nom, edat);
        this.tipus = tipus;
        this.vehiclesAssignats = new ArrayList<>();
    }

    public void afegeixVehicle(Vehicle v) {
        this.vehiclesAssignats.add(v);
    }

    public ArrayList<Vehicle> getVehiclesAssignats() {
        return this.vehiclesAssignats;
    }
    
    @Override
    public void assignaConductor(Vehicle v) {
        if (!this.vehiclesAssignats.contains(v) ) {
            this.vehiclesAssignats.add(v);
        }
    }

    @Override
    public String toString() {
        String text = "Conductor {nom=" + this.nom + ", edat=" + this.edat + ", tipus=" + this.tipus + ", Vehícles assignats={";
        for (Vehicle v : this.vehiclesAssignats) {
            text = text + "\n\t Vehicles: " +  v.toString();
        }
        text = text + " }";
        
        return text;
    }
}