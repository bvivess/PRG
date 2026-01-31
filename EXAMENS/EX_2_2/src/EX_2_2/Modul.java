package EX_2_2;

import java.util.Objects;

public class Modul {
    private String nom;
    private int consum;

    public Modul(String nom, int consum) {
        this.nom = nom;
        this.consum = consum;
    }
    
    public Modul(String nom) {
        this.nom = nom;
    }

    public int getConsum() {
        return consum;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nom);
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
        final Modul other = (Modul) obj;
        return Objects.equals(this.nom, other.nom);
    }

    @Override
    public String toString() {
        return nom + " (" + consum + "W)";
    }
}
