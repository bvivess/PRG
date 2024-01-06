package ACT9_1;

/**
 *
 * @author winadmin
 */
public class Persona {
 
    private String nombre;
    // Diferents sistemes de validació
    private String patroCodiPin;
    private String patroTeclado;
    private String patroRostre;
    private String patroHuella;
 
    public String getHuella() {
        return patroHuella;
    }
 
    public void setHuella(String patroHuella) {
        this.patroHuella = patroHuella;
    }
 
    public String getPatroRostre() {
        return patroRostre;
    }
 
    public void setPatroRostro(String patroRostre) {
        this.patroRostre = patroRostre;
    }
 
    public String getPatronTeclado() {
        return patroTeclado;
    }
 
    public void setPatronTeclado(String patroTeclado) {
        this.patroTeclado = patroTeclado;
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
