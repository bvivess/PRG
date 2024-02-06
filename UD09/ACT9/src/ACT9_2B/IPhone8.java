package ACT9_2B;

/**
 *
 * @author winadmin
 */

public class IPhone8 extends Telefon {
    
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
                return persona.getPatroCodiPin().equals(getPatroCodiPin());
            if (persona.getPatroEmprempta()!= null)
                return persona.getPatroEmprempta().equals(getPatroEmprempta());
            return false;
        } else {
            System.out.println("Telèfon IPhone8 no encès");
            return false;
        }
    }
}