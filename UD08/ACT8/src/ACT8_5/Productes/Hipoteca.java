package ACT8_5.Productes;

public class Hipoteca extends ProducteBancari{
    private double comisApertura;
    private int nombrePeriodes;

    public Hipoteca(String codiProducte, String nom, double importContractat, double interesPeriode, double comisApertura, int nombrePeriodes) {
        super(codiProducte, nom, importContractat, interesPeriode);
        this.comisApertura = comisApertura;
        this.nombrePeriodes = nombrePeriodes;
    }
    
    @Override
    public double calculaRemuneracio() {
        return - (super.getImportContractat() * super.getInteresPeriode() * this.nombrePeriodes) - this.comisApertura;
    }

    public double getComisApertura() {
        return this.comisApertura;
    }

    public void setComisApertura(double comisApertura) {
        this.comisApertura = comisApertura;
    }

    public int getNombrePeriodes() {
        return this.nombrePeriodes;
    }

    public void setNombrePeriodes(int nombrePeriodes) {
        this.nombrePeriodes = nombrePeriodes;
    }
    
    
}
