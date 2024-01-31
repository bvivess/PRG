package ACT9_1A;

/**
 *
 * @author winadmin
 */
public class Android extends Telefon implements ValidarDispositiu {
    private String patroCodiPin;
    private String patroTeclat;
    private String patroEmprempta;
 
    public Android(String marca, Persona persona) {
        super(marca, persona, false);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        setPatroCodiPin(patroCodiPin);
        setPatroTeclat(patroTeclat);
        setPatroEmprempta(patroEmprempta);
    }
    
    private void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    }

    private void setPatroEmprempta(String patroEmprempta) {
        this.patroEmprempta = patroEmprempta;
    }
 
    private void setPatroTeclat(String patroTeclat) {
        this.patroTeclat = patroTeclat;
    }
 
    @Override
    public boolean validaPatrons(Persona persona) {
        if (super.getOnOff())
            if (persona.getPatroTeclat() != null) 
                return persona.getPatroTeclat().equals(patroTeclat);
            else
                return false;
        else {
            System.out.println("Telèfon Android no encès");
            return false;
        }
    }

}
