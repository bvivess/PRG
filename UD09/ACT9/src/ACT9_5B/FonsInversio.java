package ACT9_5B;

/**
 *
 * @author Administrador
 */
public class FonsInversio extends ProducteBancari {
    private double comisApertura;
    private int nombrePeriodes;

    public FonsInversio(String codiProducte, String nom, double importContractat, double interesPeriode, double comisApertura, int nombrePeriodes) {
        super(codiProducte, nom, importContractat, interesPeriode);
        setComisApertura(comisApertura);
        setNombrePeriodes(nombrePeriodes);
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

    public void setComisApertura(double comisApertura) {
        this.comisApertura = comisApertura;
    }

    public void setNombrePeriodes(int nombrePeriodes) {
        this.nombrePeriodes = nombrePeriodes;
    }
    
}
