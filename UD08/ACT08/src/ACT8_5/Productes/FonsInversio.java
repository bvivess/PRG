package ACT8_5.Productes;

public final class FonsInversio extends ProducteBancari {
    private double comisApertura;
    private int nombrePeriodes;

    public FonsInversio(String codiProducte, String nom, double importContractat, double interesPeriode, double comisApertura, int nombrePeriodes) {
        super(codiProducte, nom, importContractat, interesPeriode);
        this.comisApertura = comisApertura;
        this.nombrePeriodes = nombrePeriodes;
    }

    /*
    * ELIMINAT A MODE D'EXEMPLE PER LA PRESÈNCIA DE 'ProducteBancari.calculaRemuneracio()'
    @Override
    public double calculaRemuneracio() {
        return + (super.getImportContractat() * super.getInteresPeriode() * this.getNombrePeriodes()) - this.getComisApertura();
    }
    */

    public double getComisApertura() {
        return comisApertura;
    }

    public int getNombrePeriodes() {
        return nombrePeriodes;
    }

    @Override
    public String toString() {
        return super.toString() + " this.FonsInversio{" + "comisApertura=" + this.comisApertura + ", nombrePeriodes=" + this.nombrePeriodes + '}';
    }
    
}
