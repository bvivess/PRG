package ACT9_0A;

/**
 *
 * @author winadmin
 */
public class Android extends Telefono  implements Validar{
    private String patron;
 
    public Android(String marca, Persona persona) {
        super(marca, persona);
        // TODO Auto-generated constructor stub
    }

    public String getPatron() {
        return patron;
    }
 
    public void setPatron(String patron) {
        this.patron = patron;
    }
 
    @Override
    public boolean validar(Persona persona) {
        if (persona.getPatron()!=null) 
            return persona.getPatron().equals(patron);
        else
            return false;
    }

}
