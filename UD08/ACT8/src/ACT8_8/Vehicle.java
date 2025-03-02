package ACT8_8;

// Classe abstracta Vehicle

import java.util.ArrayList;
import java.util.Objects;

abstract class Vehicle {
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
    }
    
    public abstract double calculaImpost();
    
    public abstract double calculaManteniment();
    
    public double calculaReparacions() {
        double total=0;
        for (Reparacio r : this.reparacions)
            total += r.preu;
        
        return total;
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
        final Vehicle other = (Vehicle) obj;
        return Objects.equals(this.matricula, other.matricula);
    }
    
    
    
    @Override
    public String toString() {
        return marca + " " + model + " (" + any + ")";
    }
}
