package ACT9_4B;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class CompteEstalvis extends ProducteBancari {
    double comisMantCompte;
    ArrayList<Tarjeta> tarjetes;

    public CompteEstalvis(String codiProducte, String nom, double importContractat, double interesPeriode, double comisMantCompte, ArrayList<Tarjeta> tarjetes) {
        super(codiProducte, nom, importContractat, interesPeriode);
        this.comisMantCompte = comisMantCompte;
        this.tarjetes = tarjetes;
    }
    
    @Override
    double calculaRemuneracio() {
        double remuneracio = -(this.comisMantCompte);
        for (Tarjeta t : this.tarjetes) {
            remuneracio -= t.comisUs;
        }
        
        return remuneracio;
    }
    
}
