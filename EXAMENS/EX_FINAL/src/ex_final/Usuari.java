package ex_final;

import java.io.Serializable;
import java.util.Objects;

public class Usuari implements Serializable {
    private String nom;
    private String correu;
    private int edat;

    public Usuari(String nom, String correu, int edat) {
        this.nom = nom;
        this.correu = correu;
        this.edat = edat;
    }

    public String getNom() { return nom; }
    public String getCorreu() { return correu; }
    public int getEdat() { return edat; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuari usuari)) return false;
        return correu.equals(usuari.correu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correu);
    }

    @Override
    public String toString() {
        return nom + " (" + correu + ", " + edat + " anys)";
    }
}

