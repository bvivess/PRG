package ACT9_1;

/**
 *
 * @author winadmin
 */
public class Persona {
 
    private String nombre;
    // Diferents sistemes de validació
    private String patroCodiPin;
    private String patroTeclat;
    private String patroRostre;
    private String patroEmprenta;
 
    public String getEmprenta() {
        return patroEmprenta;
    }
 
    public void setHuella(String patroEmprenta) {
        this.patroEmprenta = patroEmprenta;
    }
 
    public String getPatroRostre() {
        return patroRostre;
    }
 
    public void setPatroRostro(String patroRostre) {
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
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
