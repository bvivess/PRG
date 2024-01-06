package ACT9_1;

/**
 *
 * @author winadmin
 */

public class IPhone8 extends Telefono implements ValidarDispositiu {
     private int codiPin;
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

    public int getCodiPin() {
        return codiPin;
    }
 
    public void setCodiPin(int codiPin) {
        this.codiPin = codiPin;
    }
 
    @Override
    public boolean validarPersona(Persona persona) {
        if (super.getOnOff()) {
            if (persona.getHuella()!= null) {
                return persona.getHuella().equals(patroEmprenta);
            }

            if (persona.getPatroCodiPin()!= null) {
                return persona.getPatroCodiPin().equals(codiPin);
            }
            
            return false;
        } else {
            System.out.println("Telèfon IPhone8 no encès");
            return false; 
        }
    }
     
}