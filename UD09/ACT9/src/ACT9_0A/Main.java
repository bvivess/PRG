package ACT9_0A;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        
        // Persona1
        Persona p1 = new Persona();
        p1.setNombre("Juan");
        p1.setHuella("huella1");
        
        // Persona2
        Persona p2 = new Persona();
        p2.setNombre("Gemma");
        p2.setHuella("huella2");
        
        Persona p3 = new Persona();
        p3.setNombre("Pedro");
        p3.setPatronTeclado("patron1");
        
        // IPhone8
        IPhone8 iphone8 = new IPhone8("Apple",p1);
        iphone8.setPatronHuella("huella1");
        
        // IPhone10
        IPhone10 iphone10 = new IPhone10("Apple",p2);
        iphone10.setPatronHuella("huella2");
        
        // Android
        Android android1 = new Android("Samsung", p3);
        android1.setPatronTeclado("patron1");
        
        // Validacions
        System.out.println("IPhone8: ");
        System.out.print("\t" + p1.getNombre() + " " + iphone8.validar(p1) + " ");
        System.out.print("\t" + p2.getNombre() + " " + iphone8.validar(p2) + " ");
        System.out.println();
        System.out.println("IPhone10: ");
        System.out.print("\t" + p1.getNombre() + " " + iphone10.validar(p1) + " ");
        System.out.print("\t" + p2.getNombre() + " " + iphone10.validar(p2) + " ");
        System.out.println();
        System.out.println("Android: ");
        System.out.print("\t" + p1.getNombre() + " " + android1.validar(p1) + " ");
        System.out.print("\t" + p2.getNombre() + " " + android1.validar(p2) + " ");
        System.out.print("\t" + p3.getNombre() + " " + android1.validar(p3) + " ");
        System.out.println();
        
    }
}
