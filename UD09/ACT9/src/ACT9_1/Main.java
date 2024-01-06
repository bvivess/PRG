package ACT9_1;

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
        
        // Persona3
        Persona p3 = new Persona();
        p3.setNombre("Pedro");
        p3.setPatroTeclat("patron1");
        
        // Persona4
        Persona p4 = new Persona();
        p4.setNombre("Maria");
        p4.setPatroCodiPin("1234");
                
        // IPhone8
        IPhone8 iphone8 = new IPhone8("Apple",p1);
        iphone8.setPatroCodiPin("1234");
        iphone8.setPatroEmprenta("huella1");
        iphone8.setOnOff(true);
        
        // IPhone10
        IPhone10 iphone10 = new IPhone10("Apple",p2);
        iphone10.setPatroEmprenta("huella2");
        iphone10.setOnOff(true);
        
        // Android
        Android android1 = new Android("Samsung", p3);
        android1.setPatroCodiPin("1234");
        android1.setPatroTeclat("patron1");
        android1.setOnOff(true);
        
        // Validacions
        System.out.println("IPhone8: ");
        System.out.print("\t" + p1.getNombre() + " " + iphone8.validarPatrons(p1) + " ");
        System.out.print("\t" + p2.getNombre() + " " + iphone8.validarPatrons(p2) + " ");
        System.out.print("\t" + p3.getNombre() + " " + iphone8.validarPatrons(p3) + " ");
        System.out.println();
        System.out.println("IPhone10: ");
        System.out.print("\t" + p1.getNombre() + " " + iphone10.validarPatrons(p1) + " ");
        System.out.print("\t" + p2.getNombre() + " " + iphone10.validarPatrons(p2) + " ");
        System.out.print("\t" + p3.getNombre() + " " + iphone8.validarPatrons(p3) + " ");
        System.out.println();
        System.out.println("Android: ");
        System.out.print("\t" + p1.getNombre() + " " + android1.validarPatrons(p1) + " ");
        System.out.print("\t" + p2.getNombre() + " " + android1.validarPatrons(p2) + " ");
        System.out.print("\t" + p3.getNombre() + " " + android1.validarPatrons(p3) + " ");
        System.out.println();
        
    }
}
