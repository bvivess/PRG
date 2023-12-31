package ACT9_0A;

/**
 *
 * @author winadmin
 */

public class IPhone8 extends  Telefono implements Validar {
     private int codigo;
     private String huella;

    public IPhone8(String marca, Persona persona) {
        super(marca, persona);
        // TODO Auto-generated constructor stub
    }
    public String getHuella() {
        return huella;
    }
 
    public void setHuella(String huella) {
        this.huella = huella;
    }

    public int getCodigo() {
        return codigo;
    }
 
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
 
    @Override
    public boolean validar(Persona persona) {
        if (persona.getHuella()!=null) {
            return persona.getHuella().equals(huella);
        }
         
        if (persona.getCodigo()!=0) {
            return persona.getCodigo()==codigo;
        }
        
        return false;    
    }
     
     
     
}