package ACT9_4;

/**
 *
 * @author winadmin
 */
public abstract class ProducteBancari extends Banc {
    protected String codiProducte;
    protected String nom;
    protected double importContractat;
    protected double interesPeriode;
    protected boolean interesosAFavor;
    
    abstract double calculRemuneracio();

    public String getCodiProducte() {
        return codiProducte;
    }

    public void setCodiProducte(String codiProducte) {
        this.codiProducte = codiProducte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getImportContractat() {
        return importContractat;
    }

    public void setImportContractat(double importContractat) {
        this.importContractat = importContractat;
    }

    public double getInteresPeriode() {
        return interesPeriode;
    }

    public void setInteresAnual(double interesAnual) {
        this.interesPeriode = interesPeriode;
    }

    public boolean getInteresosAFavor() {
        return interesosAFavor;
    }

    public void setInteresosAFavor(boolean interesosAFavor) {
        this.interesosAFavor = interesosAFavor;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }
    
    
}
