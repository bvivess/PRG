package ACT9_1A;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Persona1
        Persona p1 = new Persona("Joan",null, null, "Emprempta1", null);
        
        // Persona2
        Persona p2 = new Persona("Gemma",null, null, "Emprempta2", null);
        
        // Persona3
        Persona p3 = new Persona("Pedro",null, "Teclat3", null, null);
        
        // Persona4
        Persona p4 = new Persona("Maria","1234", null, null, null);
                
        // IPhone8
        IPhone8 iphone8 = new IPhone8("Apple",p1);
        iphone8.setPatrons("1234", null, "Emprempta1", null);
        iphone8.setOnOff(true);
        
        // IPhone10
        IPhone10 iphone10 = new IPhone10("Apple",p2);
        iphone10.setPatrons(null, null, "Emprempta2", null);
        iphone10.setOnOff(true);
        
        // Android
        Android android1 = new Android("Samsung", p3);
        android1.setPatrons("1234", "Teclat1", null, null);
        android1.setOnOff(true);
        
        // Validacions
        System.out.println("IPhone8: ");
        System.out.print("\t" + p1.getNom() + " " + iphone8.validaPatrons(p1) + " ");
        System.out.print("\t" + p2.getNom() + " " + iphone8.validaPatrons(p2) + " ");
        System.out.print("\t" + p3.getNom() + " " + iphone8.validaPatrons(p3) + " ");
        System.out.println();
        System.out.println("IPhone10: ");
        System.out.print("\t" + p1.getNom() + " " + iphone10.validaPatrons(p1) + " ");
        System.out.print("\t" + p2.getNom() + " " + iphone10.validaPatrons(p2) + " ");
        System.out.print("\t" + p3.getNom() + " " + iphone8.validaPatrons(p3) + " ");
        System.out.println();
        System.out.println("Android: ");
        System.out.print("\t" + p1.getNom() + " " + android1.validaPatrons(p1) + " ");
        System.out.print("\t" + p2.getNom() + " " + android1.validaPatrons(p2) + " ");
        System.out.print("\t" + p3.getNom() + " " + android1.validaPatrons(p3) + " ");
        System.out.println();
        
    }
}
