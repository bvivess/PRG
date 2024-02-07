package PROVA;

/**
 *
 * @author winadmin
 */
public abstract class Telefon implements DispositiuElectronic, ValidadorDispositius  {
    private String marca;  // Marca del Telèfon
    private Persona persona;  // Dades de la persona propietària
    private boolean onOff;  // Encès o apagat
    

    
    public Telefon(String marca, Persona persona, boolean onOff) {
        // super(); // No cal ja que la interfície no té cap atribut
        this.marca = marca;
        this.persona = persona;
        this.onOff = onOff;
    }
    
    @Override
    public void on() {
        System.out.println("Telèfon encès");
        if (!this.onOff)
            this.onOff = true;
    }
    
    @Override
    public void off() {
        System.out.println("Telèfon apagat");
        if (this.onOff)
            this.onOff = false;
    }
    
    public boolean getOnOff() {
        return this.onOff;
    }
    
    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
    
    @Override
    public String toString() {
        return this.marca;
    }
}