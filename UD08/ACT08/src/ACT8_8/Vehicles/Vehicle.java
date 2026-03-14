package ACT8_8.Vehicles;

import ACT8_8.Classes.*;
import java.util.ArrayList;

// Classe abstracta Vehicle
public abstract class Vehicle {
    private String matricula;
    private String marca;
    private String model;
    private int any;
    private ArrayList<Reparacio> reparacions;

    public Vehicle(String matricula, String marca, String model, int any) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.any = any;
        this.reparacions = new ArrayList<Reparacio>();
    }
    
    // Mètodes abstractess
    public abstract double calculaImposts();
    
    public abstract double calculaManteniment();
    
    // Mètodes concrets
    public double calculaReparacions() {
        double total=0;
        for (Reparacio r : this.reparacions)
            total += r.getPreu();
        
        return total;
    }
    
    public boolean afegeixReparacio(Reparacio r) {
        if (!(this.reparacions.contains(r)))
            return this.reparacions.add(r);
        return false;
    }
    
    public boolean eliminaReparacio(String descripcio) {
        return (reparacions.remove(cercaReparacio(descripcio)) != null);
    }
    
    private int cercaReparacio(String descripcio) {
        int index = 0;
        
        for (Reparacio r : reparacions) {
            if (r.getDescripcio().equals(descripcio))
                return index;
            index++;
        }
        return -1;
    }
    
    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle v = (Vehicle) obj;
        return this.matricula.equals(v.matricula);
    }
        
    @Override
    public String toString() {
        String text = "Matrícula= " + this.matricula + " Marca= " + this.marca + " Model= " + this.model + " (" + this.any + ")";
        
        for(Reparacio r : this.reparacions)
            text += "\n\t" + r.toString();
        
        text += "\n\t> Total Reparacions=" + this.calculaReparacions() +
                "\n\t> Total Manteniment=" + this.calculaManteniment();
        
        return text;
    }
}
