package ACT9_1;

/**
 *
 * @author winadmin
 */
public abstract class Telefono implements DispositiuElectronic{
    private String marca;  // Marca del Telèfon
    private Persona persona;  // Dades de la persona propietària
    private boolean onOff;  // Encès o apagat
    
    public Telefono(String marca, Persona persona) {
        //super(); // No cal
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
        System.out.println("Telèfon encès");
        if (onOff)
            onOff = false;
    }
    
    @Override
    public void off() {
        System.out.println("Telèfon apagat");
        if (onOff)
            onOff = false;
    }
}
