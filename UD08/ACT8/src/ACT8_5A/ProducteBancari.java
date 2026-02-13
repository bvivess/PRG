package ACT8_5A;

import java.util.Objects;

/**
 *
 * @author winadmin
 */
public abstract class ProducteBancari {
    protected String codiProducte;
    protected String nom;
    protected double importContractat;
    protected double interesPeriode;

    public ProducteBancari(String codiProducte, String nom, double importContractat, double interesPeriode) {
        this.codiProducte = codiProducte;
        this.nom = nom;
        this.importContractat = importContractat;
        this.interesPeriode = interesPeriode;
    }
    
    public ProducteBancari(String codiProducte) {
        this.codiProducte = codiProducte;
    }
    
    abstract double calculaRemuneracio();

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
