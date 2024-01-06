package ACT9_1;

/**
 *
 * @author winadmin
 */
public class Android extends Telefono implements ValidarDispositiu {
    private int patroCodiPin;
    private String patroTeclat;
 
    public Android(String marca, Persona persona) {
        super(marca, persona);
        // TODO Auto-generated constructor stub
    }

    public int getPatroCodiPin() {
        return patroCodiPin;
    }

    public void setPatroCodiPin(int patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    }

    public String getPatroTeclat() {
        return patroTeclat;
    }
 
    public void setPatroTeclat(String patroTeclat) {
        this.patroTeclat = patroTeclat;
    }
 
    @Override
    public boolean validarPersona(Persona persona) {
        if (super.getOnOff())
            if (persona.getPatroTeclat() != null) 
                return persona.getPatroTeclat().equals(patroTeclat);
            else
                return false;
        else {
            System.out.println("Telèfon Android no encès");
            return false;
        }
    }

}
