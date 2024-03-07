package ACT12_0D;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author winadmin
 */
public class Persona implements Serializable {
    protected static int idEmpresa = 1;
    protected String nom;
    protected int edat; // Atribut calculat

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.nom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Persona p = (Persona) o;

        return this.nom.equals(p.nom);
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", edat=" + edat + '}';
    }

}
