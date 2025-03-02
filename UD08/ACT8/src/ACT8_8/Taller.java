package ACT8_8;

// Classe Taller que conté una llista de vehicles

import java.util.ArrayList;

class Taller {
    private String nom;
    private ArrayList<Vehicle> vehicles;
    
    public Taller(String nom) {
        this.nom = nom;
        this.vehicles = new ArrayList<>();
    }
    
    public void afegeixVehicle(Vehicle v) {
        if (!(this.vehicles.contains(v)))
            this.vehicles.add(v);
    }
    
    private Vehicle cercaVehicle(String matricula) {
        for (Vehicle v : vehicles) {
            if (v.getMatricula().equals(matricula))
                return v;
        }
        return null;
    }
    
    public double calculaTotalReparacions() {
        double total = 0.0;
        for (Vehicle v : vehicles) {
            if (v instanceof VehicleMotor) {
                total += v.calculaReparacions();
            }
        }
        return total;
    }
    
    public double calculaTotalManteniment() {
        double total = 0.0;
        for (Vehicle v : vehicles) {
            if (v instanceof VehicleMotor) {
                total += v.calculaManteniment();
            }
        }
        return total;
    }
    
    @Override
    public String toString() {
        String resultat = "Taller: " + nom + "\nVehicles:";
        for (Vehicle v : vehicles) {
            resultat += "\n - " + v.toString();
        }
        return resultat + "\nCost total manteniment: " + calculaTotalManteniment() + "EUR";
    }
}
