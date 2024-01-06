package ACT9_1;

/**
 *
 * @author winadmin
 */
public class Android extends Telefono implements ValidarDispositiu {
    private String patronTeclado;
 
    public Android(String marca, Persona persona) {
        super(marca, persona);
        // TODO Auto-generated constructor stub
    }

    public String getPatronTeclado() {
        return patronTeclado;
    }
 
    public void setPatronTeclado(String patronTeclado) {
        this.patronTeclado = patronTeclado;
    }
 
    @Override
    public boolean validar(Persona persona) {
        if (super.getOnOff())
            if (persona.getPatronTeclado() != null) 
                return persona.getPatronTeclado().equals(patronTeclado);
            else
                return false;
        else {
            System.out.println("Telèfon Android no encès");
            return false;
        }
    }

}
