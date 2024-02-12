package ACT9_2B;

/**
 *
 * @author winadmin
 */
public class Persona extends ValidadorDispositius {
 
    private String nom;
    
    Persona(String nom) {
        this.nom = nom;
    }
    
    Persona(String nom, String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        setNom(nom);
        setPatrons(patroCodiPin,patroTeclat,patroEmprempta,patroRostre);
    }

    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        setPatroCodiPin(patroCodiPin);
        setPatroTeclat(patroTeclat);
        setPatroEmprempta(patroEmprempta);
        setPatroRostre(patroRostre);
    }

    @Override
    public boolean validaPatrons(Object o) {
        Telefon telefon = null;
        if (o instanceof Android)
            telefon = (Android) o;
        else if (o instanceof IPhone8)
            telefon = (IPhone8) o;
        else if (o instanceof IPhone10)
            telefon = (IPhone10) o;
        
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
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
