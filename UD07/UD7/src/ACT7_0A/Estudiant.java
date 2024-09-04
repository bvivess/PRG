package ACT7_0A;

/**
 *
 * @author winadmin
 */
public class Estudiant extends Persona {
    private String curs;
    
    // Constructor
    public Estudiant(String nom, int edat, String curs) {
        super(nom, edat);  // Constructor de la Superclasse
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

    
}
