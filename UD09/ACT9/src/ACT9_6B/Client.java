package ACT9_6B;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Client {
    private String nom;
    private String cognom;
    private ArrayList<Producte> productes;

    public Client(String nom, String cognom, ArrayList<Producte> productes) {
        this.nom = nom;
        this.cognom = cognom;
        this.productes = productes;
    }

    // Mètode per calcular el descompte total
    public double calculaPreuTotal() {
        double preuTotal = 0.0;
        
        for (Producte p : this.productes) {
            if (p instanceof Electronic)
                preuTotal += p.getPreu() - ((Electronic) p).calculaDescompte();
            else if (p instanceof Electrodomestic)
                preuTotal += p.getPreu() - ((Electrodomestic) p).calculaSuplement();
        }

        return preuTotal;
    }

    @Override
    public String toString() {
        return "Client {" + "Nom: " + this.nom + ", Cognom: " + this.cognom + " {" +
                "\n\t," + this.productes.toString() + "\n} Descompte Total: " + this.calculaPreuTotal();
    }
    
    
}