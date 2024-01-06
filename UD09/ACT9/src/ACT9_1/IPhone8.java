package ACT9_1;

/**
 *
 * @author winadmin
 */

public class IPhone8 extends Telefono implements ValidarDispositiu {
     private String patroCodiPin;
     private String patroEmprenta;

    public IPhone8(String marca, Persona persona) {
        super(marca, persona);
        // TODO Auto-generated constructor stub
    }
    public String getPatroEmprenta() {
        return patroEmprenta;
    }
 
    public void setPatroEmprenta(String patroEmprenta) {
        this.patroEmprenta = patroEmprenta;
    }

    public String getPatroCodiPin() {
        return patroCodiPin;
    }
 
    public void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    }
 
    @Override
    public boolean validarPersona(Persona persona) {
        if (super.getOnOff()) {
            if (persona.getHuella()!= null) {
                return persona.getHuella().equals(patroEmprenta);
            }

            if (persona.getPatroCodiPin()!= null) {
                return persona.getPatroCodiPin().equals(patroCodiPin);
            }
            
            return false;
        } else {
            System.out.println("Telèfon IPhone8 no encès");
            return false; 
        }
    }
     
}