package ACT9_2B;

/**
 *
 * @author winadmin
 */
public abstract class Telefon extends ValidadorDispositius implements DispositiuElectronic {
    private String marca;  // Marca del Telèfon
    private Persona persona;  // Dades de la persona propietària
    private boolean onOff;  // Encès o apagat
        
    public Telefon(String marca, Persona persona, boolean onOff, String[] patrons) {
        super(patrons);
        this.marca = marca;
        this.persona = persona;
        this.onOff = onOff;
    }
    
    public boolean validaPatrons(Object o) {
        Persona persona = (Persona) o;
        
        if (getOnOff()) {
            if (persona.getPatroCodiPin() != null) 
                return persona.getPatroCodiPin().equals(this.getPatroCodiPin());
            if (persona.getPatroTeclat() != null) 
                return persona.getPatroTeclat().equals(this.getPatroTeclat());
            if (persona.getPatroEmprempta() != null) 
                return persona.getPatroEmprempta().equals(this.getPatroEmprempta());
            if (persona.getPatroRostre() != null) 
                return persona.getPatroRostre().equals(this.getPatroRostre());
            return false;
        } else {
            System.out.println("Telèfon no encès");
            return false;
        }
    }
    
    public boolean getOnOff() {
        return this.onOff;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setOnOff(boolean onOff) {
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
    
    @Override
    public String toString() {
        return this.marca;
    }

}
