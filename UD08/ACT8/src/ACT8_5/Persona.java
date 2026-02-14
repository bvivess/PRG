package ACT8_5;

import java.util.ArrayList;

public class Persona {
    private String nom;
    private int edat;
    private ArrayList<ProducteBancari> productesBancaris;
    
    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
        this.productesBancaris = new ArrayList<>();
    }
    
    boolean afegirProducteBancari(ProducteBancari p) {
        if (!this.productesBancaris.contains(p))
            return this.productesBancaris.add(p);
        return false;
    }
    
    boolean eliminaProducteBancari(String c) {
        /*
        return this.productesBancaris.remove(new ProducteBancari(c) { @Override
                                                                      double calculaRemuneracio() {
                                                                          return 0;
                                                                      }
                                                                    });  // Classe anònima amb mètode
        */
        for (int i = 0; i < this.productesBancaris.size(); i++) {
            if (productesBancaris.get(i).getCodiProducte().equals(c)) {
                this.productesBancaris.remove(i);
                return true;  // eliminem només la primera coincidència
            }
        }
        return false;  // no hi havia cap coincidència
    }
    
    double calculaRemuneracioTotal() {
        double remuneracio = 0;
        for (ProducteBancari p : productesBancaris) {
            remuneracio += p.calculaRemuneracio();
        }
        
        return remuneracio;
    }

    @Override
    public String toString() {
        String text;
        text = "Persona nom=" + nom + ", edat=" + edat;
        for (ProducteBancari p : productesBancaris)
            text += "\n\t" + p.toString() + " Remuneració: " + p.calculaRemuneracio();;
        
        return text;
    }

}
