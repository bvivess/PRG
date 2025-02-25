package ACT8_6B;

import java.util.ArrayList;

public class Persona {
    protected String nom;
    protected String cognom;
    protected ArrayList<Producte> productes;

    public Persona(String nom, String cognom) {
        this.nom = nom;
        this.cognom = cognom;
        this.productes = new ArrayList<Producte>();
    }
    
    public double calculaPreuTotal() {
        double total = 0;
        for (Producte p : this.productes)
            total += p.calculaPreu();
        return 0;
    }
    
    
}
