package ACT9_1;

/**
 *
 * @author winadmin
 */

public class IPhone8 extends Telefon implements ValidarDispositiu {
    private String patroCodiPin;
    private String patroEmprempta;

    public IPhone8(String marca, Persona persona) {
        super(marca, persona);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        setPatroCodiPin(patroCodiPin);
        setPatroEmprempta(patroEmprempta);
    }
    
    protected String getPatroEmprempta() {
        return patroEmprempta;
    }
 
    protected void setPatroEmprempta(String patroEmprempta) {
        this.patroEmprempta = patroEmprempta;
    }

    protected  String getPatroCodiPin() {
        return patroCodiPin;
    }
 
    protected void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    }
 
    @Override
    public boolean validarPatrons(Persona persona) {
        if (super.getOnOff()) {
            if (persona.getEmprempta()!= null) {
                return persona.getEmprempta().equals(patroEmprempta);
            }

            if (persona.getPatroCodiPin()!= null) {
                return persona.getPatroCodiPin().equals(patroCodiPin);
            }
            
            return false;
        } else {
            System.out.println("Tel�fon IPhone8 no enc�s");
            return false; 
        }
    }
     
}