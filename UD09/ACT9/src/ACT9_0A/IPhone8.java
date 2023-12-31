package ACT9_0A;

/**
 *
 * @author winadmin
 */

public class IPhone8 extends Telefono implements Validar {
     private int codigoPin;
     private String patronHuella;

    public IPhone8(String marca, Persona persona) {
        super(marca, persona);
        // TODO Auto-generated constructor stub
    }
    public String getPatronHuella() {
        return patronHuella;
    }
 
    public void setPatronHuella(String patronHuella) {
        this.patronHuella = patronHuella;
    }

    public int getCodigoPin() {
        return codigoPin;
    }
 
    public void setCodigoPin(int codigoPin) {
        this.codigoPin = codigoPin;
    }
 
    @Override
    public boolean validar(Persona persona) {
        if (super.getOnOff()) {
            if (persona.getHuella()!= null) {
                return persona.getHuella().equals(patronHuella);
            }

            if (persona.getCodigoPin()!= null) {
                return persona.getCodigoPin().equals(codigoPin);
            }
            
            return false;
        } else {
            System.out.println("Telèfon IPhone8 no encès");
            return false; 
        }
    }
     
}