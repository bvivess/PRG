package ACT7_4;


// =============================
// Classe abstracta Vehicle
// =============================
import java.util.*;

class Vehicle {
    private String marca;
    private String model;
    private double preuBase;
    private List<Caracteristica> caracteristiques;
    private List<Extra> extres;

    public Vehicle(String marca, String model, double preuBase) {
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.caracteristiques = new ArrayList<>();
        this.extres = new ArrayList<>();
    }
    
    public double calculaPreu() {
        double total = this.preuBase;
        
        for (Extra e : this.extres)
            total += e.getPreu();
        
        return total;
    }

    public void afegeixCaracteristica(Caracteristica c) {
        this.caracteristiques.add(c);
    }

    public void afegeixExtra(Extra e) {
        this.extres.add(e);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle v = (Vehicle) o;
        return marca.equals(v.marca) && model.equals(v.model);
    }

    @Override
    public String toString() {
        return "Vehicle [" + this.marca + " " + this.model + "] Preu final: " + calculaPreu() + " ¤\n" +
               "Característiques: " + this.caracteristiques + "\n" +
               "Extres: " + extres + "\n";
    }

    protected double getPreuBase() {
        return this.preuBase;
    }
}
