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
        this.reparacions = new ArrayList<Reparacio>();
    }
    
    public abstract double calculaImposts();
    
    public abstract double calculaManteniment();
    
    public void afegeixReparacio(Reparacio r) {
        if (!(this.reparacions.contains(r)))
            this.reparacions.add(r);
    }
    
    private Reparacio cercaReparacio(String descripcio) {
        for (Reparacio r : reparacions) {
            if (r.getDescripcio().equals(descripcio))
                return r;
        }
        return null;
    }
    
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
        String text = "Matrícula= " + this.matricula + " Marca= " + this.marca + " Model= " + this.model + " (" + this.any + ")";
        
        for(Reparacio r : this.reparacions)
            text += "\n\t" + r.toString();
        
        text += "\n\t Total Reparacions=" + this.calculaReparacions() +
                "\n\t Total Manteniment=" + this.calculaManteniment();
        
        return text;
    }
}
