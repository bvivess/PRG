package ACT8_2A;

/**
 *
 * @author winadmin
 */
public abstract class Telefon implements ValidadorDispositius, DispositiuElectronic {
    private String marca;  // Marca del Tel�fon
    private Persona persona;  // Dades de la persona propiet�ria
    private boolean onOff;  // Enc�s o apagat
    

    
    public Telefon(String marca, Persona persona) {
        // super(); // No cal ja que la interf�cie no t� cap atribut
        this.marca = marca;
        this.persona = persona;
        this.onOff = false;
    }
    
    @Override
    public void on() {
        System.out.println("Tel�fon enc�s");
        if (!this.onOff)
            this.onOff = true;
    }
    
    @Override
    public void off() {
        System.out.println("Tel�fon apagat");
        if (this.onOff)
            this.onOff = false;
    }
    
    public boolean getOnOff() {
        return this.onOff;
    }
    
    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
    
    /**
     * En una 'classe abstracta* no cal implementar ni declarar els m�todes
     * que ens obliga la 'Interf�cie' que implementa
    */
    // @Override
    // public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre);

    // @Override
    // public boolean validaPatrons(Object o);
    
    @Override
    public String toString() {
        return this.marca;
    }
}