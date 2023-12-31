package ACT9_0A;

/**
 *
 * @author winadmin
 */
public class Persona {
 
    private String nombre;
    // Diferentes sistemas de validación
    private String codigoPin;
    private String patronTeclado;
    private String patronRostro;
    private String patronHuella;
 
    public String getHuella() {
        return patronHuella;
    }
 
    public void setHuella(String patronHuella) {
        this.patronHuella = patronHuella;
    }
 
    public String getPatronRostro() {
        return patronRostro;
    }
 
    public void setPatronRostro(String patronRostro) {
        this.patronRostro = patronRostro;
    }
 
    public String getPatronTeclado() {
        return patronTeclado;
    }
 
    public void setPatronTeclado(String patronTeclado) {
        this.patronTeclado = patronTeclado;
    }
 
    public String getCodigoPin() {
        return codigoPin;
    }
 
    public void setCodigoPin(String codigoPin) {
        this.codigoPin = codigoPin;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
