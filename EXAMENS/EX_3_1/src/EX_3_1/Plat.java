package EX_3_1;

import java.util.Objects;


public class Plat {
    private String nom;

    public Plat(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nom);
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
        final Plat other = (Plat) obj;
        return Objects.equals(this.nom, other.nom);
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Plat{" + "nom=" + nom + '}';
    }
    
    
}
