package ACT9_1A;

/**
 *
 * @author winadmin
 */
public class Persona implements ValidadorDispositius {
 
    private String nom;
    // Diferents sistemes de validació
    private String patroCodiPin;
    private String patroTeclat;
    private String patroEmprempta;
    private String patroRostre;
    
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
            System.out.println("Telèfon Android no encès");
            return false;
        }        
}
 
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
 
    public String getPatroCodiPin() {
        return patroCodiPin;
    }
 
    public void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    }
    
    public String getPatroTeclat() {
        return patroTeclat;
    }
 
    public void setPatroTeclat(String patroTeclat) {
        this.patroTeclat = patroTeclat;
    }
    
    public String getPatroEmprempta() {
        return patroEmprempta;
    }
 
    public void setPatroEmprempta(String patroEmprempta) {
        this.patroEmprempta = patroEmprempta;
    }
 
    public String getPatroRostre() {
        return patroRostre;
    }
 
    public void setPatroRostre(String patroRostre) {
        this.patroRostre = patroRostre;
    }

}