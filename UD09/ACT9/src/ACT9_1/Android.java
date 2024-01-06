package ACT9_1;

/**
 *
 * @author winadmin
 */
public class Android extends Telefono implements ValidarDispositiu {
    private String patroCodiPin;
    private String patroTeclat;
    private String patroEmprempta;
 
    public Android(String marca, Persona persona) {
        super(marca, persona);
        // TODO Auto-generated constructor stub
    }

    public String getPatroCodiPin() {
        return patroCodiPin;
    }

    public void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    }

    public String getPatroEmprempta() {
        return patroEmprempta;
    }

    public void setPatroEmprempta(String patroEmprempta) {
        this.patroEmprempta = patroEmprempta;
    }

    public String getPatroTeclat() {
        return patroTeclat;
    }
 
    public void setPatroTeclat(String patroTeclat) {
        this.patroTeclat = patroTeclat;
    }
 
    @Override
    public boolean validarPatrons(Persona persona) {
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
