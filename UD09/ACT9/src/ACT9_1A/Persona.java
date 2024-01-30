package ACT9_1A;

/**
 *
 * @author winadmin
 */
public class Persona {
 
    private String nom;
    // Diferents sistemes de validació
    private String patroCodiPin;
    private String patroTeclat;
    private String patroEmprempta;
    private String patroRostre;
    
    Persona(String nom) {
        this.nom = nom;
    }
    
    Persona(String nom, String patroCodiPin, String patroTeclat, String patriEmprempta, String patroRostre) {
        this.nom = nom;
        setPatrons(patroCodiPin, patroTeclat, patriEmprempta, patroRostre);
    }
    
    public void setPatrons(String patroCodiPin, String patroTeclat, String patriEmprempta, String patroRostre) {
        setPatroCodiPin(patroCodiPin);
        setPatroTeclat(patroTeclat);
        setPatroEmprempta(patroEmprempta);
        setPatroRostre(patroRostre);
    }
    
    public String getEmprempta() {
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
 
    public String getPatroTeclat() {
        return patroTeclat;
    }
 
    public void setPatroTeclat(String patroTeclat) {
        this.patroTeclat = patroTeclat;
    }
 
    public String getPatroCodiPin() {
        return patroCodiPin;
    }
 
    public void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    }
 
    public String getNom() {
        return nom;
    }

}
