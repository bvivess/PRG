package ACT8_5.Productes;

import java.util.Objects;

public abstract class ProducteBancari implements ProducteBancariBase {
    private String codiProducte;
    private String nom;
    private double importContractat;
    private double interesPeriode;

    // Constructors
    public ProducteBancari(String codiProducte, String nom, double importContractat, double interesPeriode) {
        this.codiProducte = codiProducte;
        this.nom = nom;
        this.importContractat = importContractat;
        this.interesPeriode = interesPeriode;
    }
    
    public ProducteBancari(String codiProducte) {
        this.codiProducte = codiProducte;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.codiProducte);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProducteBancari other = (ProducteBancari) obj;
        return Objects.equals(this.codiProducte, other.codiProducte);
    }

    @Override
    public String toString() {
        return "ProducteBancari {" + "codiProducte=" + codiProducte + ", nom=" + nom + '}';
    }
}
