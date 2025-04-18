package EX_2_1;

import java.util.ArrayList;


/**
 * Comentari Javadoc
 * @author Administrador
 */

class Dispositiu {
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
    public float calculaPreu() {
        return this.preuBase;
    }
    
    public void setCaracteristica(Caracteristica c) {
        caracteristiques.add(c);
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