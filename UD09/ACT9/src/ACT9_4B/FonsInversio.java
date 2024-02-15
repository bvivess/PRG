package ACT9_4B;

/**
 *
 * @author Administrador
 */
public class FonsInversio extends ProducteBancari {
    private double comisApertura;
    private int nombrePeriodes;

    public FonsInversio(String codiProducte, String nom, double importContractat, double interesPeriode, double comisApertura, int nombrePeriodes) {
        super(codiProducte, nom, importContractat, interesPeriode);
        this.comisApertura = comisApertura;
        this.nombrePeriodes = nombrePeriodes;
    }

    @Override
    double calculaRemuneracio() {
        return + (super.getImportContractat() * super.getInteresPeriode() * this.getNombrePeriodes()) - this.getComisApertura();
    }

    public double getComisApertura() {
        return comisApertura;
    }

    public int getNombrePeriodes() {
        return nombrePeriodes;
    }
    
}
