package ACT8_6.Classes;

import java.util.ArrayList;
import ACT8_6.Productes.*;

public class Client {
    private String nom;
    private String llinatge;
    private ArrayList<Producte> productes;

    public Client(String nom, String llinatge) {
        this.nom = nom;
        this.llinatge = llinatge;
        this.productes = new ArrayList<Producte>();
    }
    
    public boolean afegeixProducte(Producte p) {
        if (!(this.productes.contains(p)))
            return this.productes.add(p);
        return false;
    }
    
    public boolean eliminaProducte(String s) {
        int posicio = this.cercaProducte(s);
        
        if (posicio != -1) {
           this.productes.remove(posicio);
           return true;
        } else 
            return false;
    }

    public int cercaProducte(String s) {
        int i = 0;
        for (Producte p : this.productes) {
            if (p.getNom().equals(s))
                return i;
            i++;
        }
        return -1;
    }

    // Mètode per calcular preu total del 'productes' 
    public double calculaPreuTotal() {
        double preuTotal = 0.0;
        
        for (Producte p : this.productes)
            preuTotal += p.calculaPreu();
        
        return preuTotal;
    }

    @Override
    public String toString() {
        String text = "Client {Nom: " + this.nom + ", Cognom: " + this.llinatge + " Productes={";
        
        for (Producte p : productes)
            text += "\n\t " + p.toString();
        
        text += "\n} Preu Total: " + this.calculaPreuTotal();
        return text;
    }
    
    
}