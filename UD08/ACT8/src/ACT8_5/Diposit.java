package ACT8_5;

public class Diposit extends ProducteBancari {
    private int nombrePeriodes;

    public Diposit(String codiProducte, String nom, double importContractat, double interesPeriode, int nombrePeriodes) {
        super(codiProducte, nom, importContractat, interesPeriode);
        this.nombrePeriodes = nombrePeriodes;
    }

    @Override
    double calculaRemuneracio() {
        return + (super.getImportContractat() * super.getInteresPeriode() * this.nombrePeriodes);
    }

    public int getNombrePeriodes() {
        return this.nombrePeriodes;
    }

    public void setNombrePeriodes(int nombrePeriodes) {
        this.nombrePeriodes = nombrePeriodes;
    }
    
}
