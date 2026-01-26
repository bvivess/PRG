package ACT7_4;

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
        String text = "Vehicle [" + "Marca:" + this.marca + " Model: " + this.model + " Preu base: " + this.preuBase + " EUR]\n";
        
        text += "Caracteristiques: ";
        for (Caracteristica c : this.caracteristiques)
            text += c.toString() + " ";
        
        text += "\nExtres: ";
        for (Extra e : this.extres)
            text += e.toString() + "\n";
        
        return text;
    }

}
