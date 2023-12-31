package ACT9_0A;

/**
 *
 * @author winadmin
 */
public abstract class Telefono implements Activar{
    private String marca;
    private Persona persona;
    private boolean onOff;
    
    public Telefono(String marca, Persona persona) {
        super();
        this.marca = marca;
        this.persona = persona;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public boolean getOnOff() {
        return onOff;
    }
    
    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
    
    @Override
    public void on() {
        System.out.println("telefono encendido");
        if (onOff)
            onOff = false;
    }
    
    @Override
    public void off() {
        System.out.println("telefono apagado");
        if (onOff)
            onOff = false;
    }
}
