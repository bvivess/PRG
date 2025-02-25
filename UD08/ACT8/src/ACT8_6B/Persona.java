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
        return 0;
    }
    
    
}
