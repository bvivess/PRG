package EX_2_1B;

import java.util.ArrayList;

/**
 * Comentari Javadoc
 * @author Administrador
 */

abstract class Dispositiu {
    private String marca;
    private String model;
    private float preuBase;
    private ArrayList<Caracteristica> caracteristiques;

    public Dispositiu(String marca, String model, float preuBase) {
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.caracteristiques = new ArrayList<>();
    }

    /**
     * CalculaPreu per a dispositiu
     * @return preuBase
     */
    abstract public float calculaPreu();
    
    public void setCaracteristica(Caracteristica c) {
        caracteristiques.add(c);
    }

    public float getPreuBase() {
        return preuBase;
    }
    
    @Override
    public boolean equals(Object obj) {
        Dispositiu d = (Dispositiu) obj;
        return this.marca.equals(d.marca) && this.model.equals(d.model);
    }

    @Override
    public String toString() {
        String text = "Marca: " + this.marca + 
                      ", Model: " + this.model + 
                      ", Preu base: " + this.preuBase + " EUR" + 
                      ", Preu total: " + this.calculaPreu() + " EUR";
        
        text += "\n\tCaracteristiques:";
        for (Caracteristica c : this.caracteristiques)
            text += "\n\t\t" + c.toString();

        return text;
                
    }
}