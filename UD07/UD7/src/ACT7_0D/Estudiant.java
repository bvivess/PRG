package ACT7_0D;

/**
 *
 * @author winadmin
 * 
 * @Override
 *      toString()
 *      equals()
 */
public class Estudiant extends Persona {
    private String curs;
    
    // Constructor
    public Estudiant(String nom, int edat, String curs) {
        super(nom, edat);
        this.curs = curs;
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
        
        if ( super.equals(o) && // (e.getNom().equals(this.getNom())) && (e.getEdat() == this.getEdat())
             e.curs.equals(this.curs) ) 
            return true;
        else 
            return false;
    }
    
}
