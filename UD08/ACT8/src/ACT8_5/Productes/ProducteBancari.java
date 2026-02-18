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
    
    @Override
    /** ALERTA: AQUESTA OPCIÓ ELIMINA ELS 'calculaRemuneracio()' del les classes hereves 
     * 
     * ÉS UNA OPCIÓ ALTAMENT NO RECOMANABLE, JA QUE NO ÉS UNA BONA PRÀCTICA.
     * SIMPLEMENT ES POSA A MODE D'EXEMPLE
     */
    public double calculaRemuneracio() {

        if (this instanceof CompteEstalvis compte) {
            // calculaRemuneracio de 'CompteEstalvis'
            double remuneracio = -compte.getComisMantCompte();

            for (var t : compte.getTarjetes()) {
                remuneracio -= t.getComisUs();
            }

            return remuneracio;
        } else if (this instanceof Diposit diposit) {
            // calculaRemuneracio de 'Diposit'
            return getImportContractat() * getInteresPeriode() * diposit.getNombrePeriodes();
        } else if (this instanceof Hipoteca hipoteca) {
            // calculaRemuneracio de 'Hipoteca'
            return - (getImportContractat() * getInteresPeriode() * hipoteca.getNombrePeriodes())
                    - hipoteca.getComisApertura();
        } else if (this instanceof FonsInversio fons) {
            // calculaRemuneracio de 'FonsInversio'
            return (getImportContractat() * getInteresPeriode() * fons.getNombrePeriodes())
                    - fons.getComisApertura();
        } else
            throw new UnsupportedOperationException("Tipus de producte no suportat");
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
