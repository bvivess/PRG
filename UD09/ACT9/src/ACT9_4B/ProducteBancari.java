package ACT9_4B;

/**
 *
 * @author winadmin
 */
public abstract class ProducteBancari {
    private String codiProducte;
    private String nom;
    private double importContractat;
    private double interesPeriode;

    public ProducteBancari(String codiProducte, String nom, double importContractat, double interesPeriode) {
        this.codiProducte = codiProducte;
        this.nom = nom;
        this.importContractat = importContractat;
        this.interesPeriode = interesPeriode;
    }
    
    abstract double calculaRemuneracio();

    @Override
    public String toString() {
        return "ProducteBancari {" + "codiProducte=" + codiProducte + ", nom=" + nom + '}';
    }

    public String getCodiProducte() {
        return codiProducte;
    }

    public String getNom() {
        return nom;
    }

    public double getImportContractat() {
        return importContractat;
    }

    public double getInteresPeriode() {
        return interesPeriode;
    }
    
}
