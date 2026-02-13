package ACT8_5A;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class CompteEstalvis extends ProducteBancari {
    private double comisMantCompte;
    private ArrayList<Tarjeta> tarjetes;

    public CompteEstalvis(String codiProducte, String nom, double importContractat, double interesPeriode, double comisMantCompte) {
        super(codiProducte, nom, importContractat, interesPeriode);
        this.comisMantCompte = comisMantCompte;
        this.tarjetes = new ArrayList<>();
    }
        
    boolean afegirTarjeta(Tarjeta t) {
        System.out.println(this.tarjetes.contains(t));
        if (!this.tarjetes.contains(t)) {
            return tarjetes.add(t);
        }
        return false;
    }
    
    boolean eliminaTarjeta(String c) {
        // return this.tarjetes.remove(new Tarjeta(c) {});  // Classe anònima
        
        for (int i = 0; i < this.tarjetes.size(); i++) {
            if (tarjetes.get(i).codiTarjeta.equals(c)) {
                this.tarjetes.remove(i);
                return true;  // eliminem només la primera coincidència
            }
        }
        return false;  // no hi havia cap coincidència
    }
    @Override
    double calculaRemuneracio() {
        double remuneracio = -(this.comisMantCompte);
        for (Tarjeta t : this.tarjetes) {
            remuneracio -= t.comisUs;
        }
        
        return remuneracio;
    }

    @Override
    public String toString() {
        return "CompteEstalvis{" + "comisMantCompte=" + comisMantCompte + ", tarjetes=" + tarjetes.toString() + '}';
    }
    
}
