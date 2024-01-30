package ACT9_1A;

/**
 *
 * @author winadmin
 */
public abstract class Telefon implements DispositiuElectronic{
    private String marca;  // Marca del Tel�fon
    private Persona persona;  // Dades de la persona propiet�ria
    private boolean onOff;  // Enc�s o apagat
    
    public Telefon(String marca, Persona persona, boolean onOff) {
        // super(); // No cal ja que la interf�cie no t� cap atribut
        this.marca = marca;
        this.persona = persona;
        this.onOff = onOff;
    }
    
    protected abstract void setPatrons(String patroCodiPin, String patroTeclat, String patriEmprempta, String patroRostre);
    
    public boolean getOnOff() {
        return onOff;
    }
    
    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
    
    @Override
    public void on() {
        System.out.println("Tel�fon enc�s");
        if (!onOff)
            onOff = true;
    }
    
    @Override
    public void off() {
        System.out.println("Tel�fon apagat");
        if (onOff)
            onOff = false;
    }
}