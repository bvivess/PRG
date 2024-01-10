package ACT8_0D;

import ACT8_0A.*;

/**
 *
 * @author winadmin
 */
public class Estudiant extends Persona {
    private String curs;
    
    // Constructor
    public Estudiant(String nom, int edat, String curs) {
        super(nom, edat);
        this.curs = curs;
    }
    
    void mostraEstudiant() {
        mostraPersona(); 
        System.out.println("Curs: " + curs);
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }
    @Override
    public String toString() {
        return super.toString() + " " + "ESTUDIANT Nom: " + super.getNom() + " Edat: " + super.getEdat() + " " + curs;
    }
    
    @Override
    public boolean equals(Object o) {
        Estudiant e = (Estudiant) o;
        
        if (e.getNom().equals(this.getNom())) // comparació atribut a atribut ?
            return true;
        else 
            return false;
    }
    
}
