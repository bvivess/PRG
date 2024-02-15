package ACT9_4;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Persona {
    String nom;
    int edat;
    ArrayList<ProducteBancari> productesBancaris;
    
    double calculaRemuneracioTotal() {
        double remuneracio = 0;
        for (ProducteBancari p : productesBancaris) {
            remuneracio += p.calculaRemuneracio();
        }
        
        return remuneracio;
    }
}
