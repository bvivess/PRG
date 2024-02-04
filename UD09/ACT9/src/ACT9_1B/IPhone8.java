package ACT9_1B;

import ACT9_1A.*;

/**
 *
 * @author winadmin
 */

public class IPhone8 extends Telefon {
    private String patroCodiPin;
    private String patroEmprempta;

    // Constructors
    public IPhone8(String marca, Persona persona, String patroCodiPin, String patroEmprempta) {
        super(marca, persona, false);
        setPatrons(patroCodiPin,null,patroEmprempta,null);
    }
    
    /** Constructor sense patrons, a continuació utilizar 'setPatrons'
     * 
     * @param marca
     * @param persona 
     */
    public IPhone8(String marca, Persona persona) {
        super(marca, persona, false);
    }
    
    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        setPatroCodiPin(patroCodiPin);
        setPatroEmprempta(patroEmprempta);
    }
     
    @Override
        public boolean validaPatrons(Object o) {
        Persona persona = (Persona) o;
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

    @Override
    public String getPatroCodiPin() {
        return patroCodiPin;
    }
    
    @Override
    public String getPatroTeclat() {
        return null;
    }
        
    @Override
    public String getPatroEmprempta() {
        return patroEmprempta;
    }
    
    @Override
    public String getPatroRostre() {
        return null;
    }

    public void setPatroEmprempta(String patroEmprempta) {
        this.patroEmprempta = patroEmprempta;
    }
 
    public void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    } 
}