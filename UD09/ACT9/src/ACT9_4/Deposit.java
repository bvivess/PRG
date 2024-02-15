package ACT9_4;

/**
 *
 * @author winadmin
 */
public class Deposit extends ProducteBancari {
    int nombrePeriodes;

    @Override
    double calculaRemuneracio() {
        return + (super.importContractat * this.nombrePeriodes);
    }

    public int getNombrePeriodes() {
        return nombrePeriodes;
    }

    public void setNombrePeriodes(int nombrePeriodes) {
        this.nombrePeriodes = nombrePeriodes;
    }
    
}
