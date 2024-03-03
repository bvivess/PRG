package ACT11_2;

/**
 *
 * @author T.Vives
 */
public class Persona {
    protected String nom;
    protected int edat;

    // Constructor
    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
    
    @Override
    public String toString() {
        return "Nom: " + nom + " Edat: " + edat;
    }

}