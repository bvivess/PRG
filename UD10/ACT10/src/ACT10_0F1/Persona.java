package ACT10_0F1;

import java.util.Objects;

/**
 *
 * @author winadmin
 */
public class Persona {
    private String nom;
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nom.equals(persona.nom);
    }

    // també es pot definir el mètode genèric següent
    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
    
    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", edat=" + edat + '}';
    }
}

