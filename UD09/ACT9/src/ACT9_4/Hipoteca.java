package ACT9_4;

/**
 *
 * @author winadmin
 */
public class Hipoteca extends ProducteBancari{
    double comisApertura;
    int nombrePeriodes;

    @Override
    double calculRemuneracio() {
        return - (super.importContractat * this.nombrePeriodes) - this.comisApertura;
    }

    public double getComisApertura() {
        return comisApertura;
    }

    public void setComisApertura(double comisApertura) {
        this.comisApertura = comisApertura;
    }

    public int getNombrePeriodes() {
        return nombrePeriodes;
    }

    public void setNombrePeriodes(int nombrePeriodes) {
        this.nombrePeriodes = nombrePeriodes;
    }
    
    
}
