package ACT8_2A;

/**
 *
 * @author winadmin
 */
public class IPhone10 extends IPhone8{
     private String patroRostre;
     
    //Constructors
     /*
    public IPhone10(String marca, Persona persona, String patroCodiPin, String patroEmprempta, String patroRostre) {
        super(marca, persona);
        setPatrons(patroCodiPin,null,patroEmprempta,patroRostre);
    } */
    
    /** Constructor sense patrons, a continuaci� utilizar 'setPatrons'
     * 
     * @param marca
     * @param persona 
     */
    public IPhone10(String marca, Persona persona) {
        super(marca, persona);
    }
    
    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        super.setPatroCodiPin(patroCodiPin);
        super.setPatroEmprempta(patroEmprempta);
        setPatroRostre(patroRostre);
    }
    
    @Override
    public boolean validaPatrons(Object o) {
        Persona persona = (Persona) o;
        if (super.getOnOff()) {
            if (super.validaPatrons(persona))
                return true;
            else
                if (persona.getPatroRostre() != null)
                    return persona.getPatroRostre().equals(patroRostre);
            return false;
        } else {
            System.out.println("Tel�fon IPhone 10 no enc�s");
            return false; 
        }
            
    } 
 
    public void setPatroRostre(String patroRostre) {
        this.patroRostre = patroRostre;
    }    
}
