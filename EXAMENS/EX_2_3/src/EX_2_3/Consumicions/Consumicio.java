package EX_2_3.Consumicions;

import java.util.Objects;

public abstract class Consumicio {
    private String nom;
    private double preu;

    public Consumicio(String nom, double preu) {
        this.nom = nom;
        this.preu = preu;
    }
    
    public Consumicio(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        // Les comparacions 'Dolc','Salat' són correctes
        // Les comparacions 'Refresc','Infusio','Alcohol','Combinat' són correctes
        //if (getClass() != obj.getClass()) {
        //    return false;
        //}
        if (!(obj instanceof Consumicio))
            return false;
        
        final Consumicio other = (Consumicio) obj;
        return Objects.equals(this.nom, other.nom);
    }
 
    @Override
    public String toString() {
        return "Consumicio{" + "nom=" + nom + ", preu=" + preu + "}";
    }   
    
}
