package ACT9_1;

/**
 *
 * @author winadmin
 */
public class IPhone10 extends IPhone8{
     private String patroRostre;
     
    public IPhone10(String marca, Persona persona) {
        super(marca, persona);
    }
 
    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        super.setPatroCodiPin(patroCodiPin);
        super.setPatroEmprempta(patroEmprempta);
        setPatroRostre(patroRostre);
    }
    
    private String getPatroRostre() {
        return patroRostre;
    }
 
    private void setPatroRostre(String patroRostre) {
        this.patroRostre = patroRostre;
    }
    
    @Override
    public boolean validarPatrons(Persona persona) {
        if (super.getOnOff()) {
            if (persona.getPatroRostre()!=null) {
                return persona.getPatroRostre().equals(patroRostre);
            }
            return super.validarPatrons(persona);
        } else {
            System.out.println("Telèfon IPhone 10 no encès");
            return false; 
        }
            
    } 
}