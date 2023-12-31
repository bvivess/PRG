package ACT9_0A;

/**
 *
 * @author winadmin
 */
public class Android extends Telefono  implements Validar{
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
        if (persona.getPatronTeclado()!=null) 
            return persona.getPatronTeclado().equals(patronTeclado);
        else
            return false;
    }

}
