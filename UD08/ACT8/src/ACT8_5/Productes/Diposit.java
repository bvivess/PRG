package ACT8_5.Productes;

public final class Diposit extends ProducteBancari {
    private int nombrePeriodes;

    public Diposit(String codiProducte, String nom, double importContractat, double interesPeriode, int nombrePeriodes) {
        super(codiProducte, nom, importContractat, interesPeriode);
        this.nombrePeriodes = nombrePeriodes;
    }

    /*
    * ELIMINAT A MODE D'EXEMPLE PER LA PRESÈNCIA DE 'ProducteBancari.calculaRemuneracio()'
    @Override
    public double calculaRemuneracio() {
        return + (super.getImportContractat() * super.getInteresPeriode() * this.nombrePeriodes);
    }
    */
    
    public int getNombrePeriodes() {
        return this.nombrePeriodes;
    }

    @Override
    public String toString() {
        return super.toString() + " Diposit{" + "nombrePeriodes=" + nombrePeriodes + '}';
    }
    
    
}
