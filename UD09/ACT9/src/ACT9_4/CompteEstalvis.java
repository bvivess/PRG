package ACT9_4;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class CompteEstalvis extends ProducteBancari {
    double comisMantCompte;
    ArrayList<Tarjeta> tarjetes;

    @Override
    double calculaRemuneracio() {
        double remuneracio = -(this.comisMantCompte);
        for (Tarjeta t : this.tarjetes) {
            remuneracio -= t.comisUs;
        }
        
        return remuneracio;
    }
    
}
