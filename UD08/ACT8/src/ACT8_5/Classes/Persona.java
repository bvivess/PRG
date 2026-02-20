package ACT8_5.Classes;

import java.util.ArrayList;
import ACT8_5.Productes.ProducteBancari;

public class Persona {
    private String nom;
    private int edat;
    private ArrayList<ProducteBancari> productesBancaris;
    
    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
        this.productesBancaris = new ArrayList<>();
    }
    
    public boolean afegeixProducteBancari(ProducteBancari p) {
        if (!this.productesBancaris.contains(p))
            return this.productesBancaris.add(p);
        return false;
    }
    
    public boolean eliminaProducteBancari(String c) {
        /*
        return this.productesBancaris.remove(new ProducteBancari(c) { @Override
                                                                      double calculaRemuneracio() {
                                                                          return 0;
                                                                      }
                                                                    });  // Classe anònima amb mètode
        */
        
        int pos = cercaProducteBancari(c);
        if (pos != -1) {
            this.productesBancaris.remove(pos);
            return true;  // eliminem només la primera coincidència
        } else
            return false;  // no hi havia cap coincidència
    }
    
    private int cercaProducteBancari(String c) {
        for (int i = 0; i < this.productesBancaris.size(); i++) 
            if (productesBancaris.get(i).getCodiProducte().equals(c)) 
                return i;
        return -1;
    }
    
    public double calculaRemuneracioTotal() {
        double remuneracio = 0;
        for (ProducteBancari p : productesBancaris) {
            remuneracio += p.calculaRemuneracio();
        }
        
        return remuneracio;
    }

    @Override
    public String toString() {
        String text;
        text = "Persona nom=" + nom + ", edat=" + edat + ", Remuneració total= " + this.calculaRemuneracioTotal();
        for (ProducteBancari p : productesBancaris)
            text += "\n\t" + p.toString();
        
        return text;
    }

}
