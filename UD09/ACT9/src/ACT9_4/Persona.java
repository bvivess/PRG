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
            if (p instanceof Deposit)
                remuneracio += p.getImportContractat() * p.getInteresPeriode() * ((Deposit) p).getNombrePeriodes();
            else if (p instanceof Hipoteca)
                remuneracio -= p.getImportContractat() * p.getInteresPeriode() * ((Hipoteca) p).getNombrePeriodes();
            
        }
        
        return remuneracio;
    }
}
