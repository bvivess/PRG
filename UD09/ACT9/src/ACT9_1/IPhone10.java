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
 
    public String getPatroRostre() {
        return patroRostre;
    }
 
    public void setPatroRostre(String patroRostre) {
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