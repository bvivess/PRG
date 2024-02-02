package ACT9_1A;

/**
 *
 * @author winadmin
 */

public class IPhone8 extends Telefon implements ValidadorDispositius {
    private String patroCodiPin;
    private String patroEmprempta;

    // Constructors
    public IPhone8(String marca, Persona persona, String patroCodiPin, String patroEmprempta) {
        super(marca, persona, false);
        this.patroCodiPin = patroCodiPin;
        this.patroEmprempta = patroEmprempta;
    }
    
    /** Constructor sense patrons, a continuació utilizar 'setPatrons'
     * 
     * @param marca
     * @param persona 
     */
    public IPhone8(String marca, Persona persona) {
        super(marca, persona, false);
        setPatrons(patroCodiPin,null,patroEmprempta,null);
    }
    
    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        setPatroCodiPin(patroCodiPin);
        setPatroEmprempta(patroEmprempta);
    }
    
 
    protected void setPatroEmprempta(String patroEmprempta) {
        this.patroEmprempta = patroEmprempta;
    }
 
    protected void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    }
 
    @Override
    public boolean validaPatrons(Persona persona) {
        if (super.getOnOff()) {
            if (persona.getPatroCodiPin()!= null)
                return persona.getPatroCodiPin().equals(patroCodiPin);
            if (persona.getPatroEmprempta()!= null)
                return persona.getPatroEmprempta().equals(patroEmprempta);
            return false;
        } else {
            System.out.println("Telèfon IPhone8 no encès");
            return false;
        }
    }
     
}