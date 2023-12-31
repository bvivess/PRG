package ACT9_0A;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
         
        Persona p= new Persona();
        p.setNombre("juan");
        p.setHuella("huella1");
         
        IPhone8 telefono= new IPhone8("apple",p);
         
        telefono.setHuella("huella1");
        System.out.println(telefono.validar(p));
         
        Persona p1= new Persona();
        p1.setNombre("gema");
        p1.setHuella("huella2");
        System.out.println(telefono.validar(p1));
        
    }
}
