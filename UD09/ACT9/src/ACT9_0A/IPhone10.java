package ACT9_0A;

/**
 *
 * @author winadmin
 */
public class IPhone10 extends IPhone8{
     private String patronRostro;
     
    public IPhone10(String marca, Persona persona) {
        super(marca, persona);
        // TODO Auto-generated constructor stub
    }
 
    public String getPatronRostro() {
        return patronRostro;
    }
 
    public void setPatronRostro(String patronRostro) {
        this.patronRostro = patronRostro;
    }
    
    @Override
    public boolean validar(Persona persona) {
         
        if(persona.getPatronRostro()!=null) {
             
            return persona.getPatronRostro().equals(patronRostro);
        }
         
        return super.validar(persona);
    } 
}
