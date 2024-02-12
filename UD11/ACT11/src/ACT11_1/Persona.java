package ACT11_1;

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
    void mostraPersona() {
        System.out.println("Nom: " + nom + " Edat: " + edat);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

}