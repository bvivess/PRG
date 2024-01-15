package ACT8_0D;

/**
 *
 * @author T.Vives
 * 
 * @Override
 *      toString()
 *      equals()
 */
public class Persona {
    private String nom;
    private int edat;

    // Constructor
    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
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

    @Override
    public String toString() {
        return "PERSONA Nom: " + nom + " Edat: " + edat;
    }
    
    /*@Override
    public boolean equals(Object o) {
        Persona p = (Persona) o;
        
        if (p.nom.equals(nom)) // comparació atribut a atribut ?
            return true;
        else 
            return false;
    }
    */

}
    
    
