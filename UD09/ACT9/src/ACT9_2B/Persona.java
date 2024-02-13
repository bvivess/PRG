package ACT9_2B;

/**
 *
 * @author winadmin
 */
public class Persona extends ValidadorDispositius {
    private String nom;
    
    // Constructors
    public Persona(String[] patrons, String nom) {
        super(patrons);
        this.nom = nom;
    }
    
    public Persona(String nom) {
        super(new String[] {null, null, null, null});
        this.nom = nom;
    }

    @Override
    public boolean validaPatrons(Object o) {
        Telefon telefon = (Telefon) o;
        
        if (telefon.getOnOff()) {
            if (this.getPatroCodiPin() != null) 
                return this.getPatroCodiPin().equals(telefon.getPatroCodiPin());
            if (this.getPatroTeclat() != null) 
                return this.getPatroTeclat().equals(telefon.getPatroTeclat());
            if (this.getPatroEmprempta() != null) 
                return this.getPatroEmprempta().equals(telefon.getPatroEmprempta());
            if (this.getPatroRostre() != null) 
                return this.getPatroRostre().equals(telefon.getPatroRostre());
            return false;
        } else {
            System.out.println("Telèfon no encès");
            return false;
        }     
    }

    public String getNom() {
        return this.nom;
    }
    
}
