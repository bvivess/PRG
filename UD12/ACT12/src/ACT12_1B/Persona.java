package ACT12_1B;

import java.util.Objects;

public class Persona {
    private String nom;
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
    
    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", edat=" + edat + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nom.equals(persona.nom) && edat == persona.edat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, edat);
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

}

