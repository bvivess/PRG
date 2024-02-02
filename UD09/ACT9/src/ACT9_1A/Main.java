package ACT9_1A;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Persona1
        Persona p1 = new Persona("Joan","1234", null, null, null);
        
        // Persona2
        Persona p2 = new Persona("Gemma",null, "Teclat2", null, null);
        
        // Persona3
        Persona p3 = new Persona("Pere",null, null, "Emprempta3", null);
        
        // Persona4
        Persona p4 = new Persona("Maria",null, null, null, "Rostre4");
        
        // Android
        Android android1 = new Android("Samsung", p3,"1234", null, null);
        android1.setOnOff(true);
        
        Android android2 = new Android("Samsung", p3,null, "Teclat2", null);
        android2.setOnOff(true);
        
        // IPhone8
        IPhone8 iphone8 = new IPhone8("Apple",p1, null, "Emprempta3");
        iphone8.setOnOff(true);
        
        // IPhone10
        IPhone10 iphone10 = new IPhone10("Apple",p2,null, null, "Rostre4");
        iphone10.setOnOff(true);
        
        // Validacions
        System.out.println("Android1: ");
        System.out.print("\t" + p1.getNom() + " " + android1.validaPatrons(p1) + " ");
        System.out.print("\t" + p2.getNom() + " " + android1.validaPatrons(p2) + " ");
        System.out.print("\t" + p3.getNom() + " " + android1.validaPatrons(p3) + " ");
        System.out.print("\t" + p4.getNom() + " " + android1.validaPatrons(p4) + " ");
        System.out.println("");
        System.out.println("Android2: ");
        System.out.print("\t" + p1.getNom() + " " + android2.validaPatrons(p1) + " ");
        System.out.print("\t" + p2.getNom() + " " + android2.validaPatrons(p2) + " ");
        System.out.print("\t" + p3.getNom() + " " + android2.validaPatrons(p3) + " ");
        System.out.print("\t" + p4.getNom() + " " + android2.validaPatrons(p4) + " ");
        System.out.println("");
        System.out.println("IPhone8: ");
        System.out.print("\t" + p1.getNom() + " " + iphone8.validaPatrons(p1) + " ");
        System.out.print("\t" + p2.getNom() + " " + iphone8.validaPatrons(p2) + " ");
        System.out.print("\t" + p3.getNom() + " " + iphone8.validaPatrons(p3) + " ");
        System.out.print("\t" + p4.getNom() + " " + iphone8.validaPatrons(p4) + " ");
        System.out.println("");
        System.out.println("IPhone10: ");
        System.out.print("\t" + p1.getNom() + " " + iphone10.validaPatrons(p1) + " ");
        System.out.print("\t" + p2.getNom() + " " + iphone10.validaPatrons(p2) + " ");
        System.out.print("\t" + p3.getNom() + " " + iphone10.validaPatrons(p3) + " ");
        System.out.print("\t" + p4.getNom() + " " + iphone10.validaPatrons(p4) + " ");
        System.out.println();

        System.out.println();
        
    }
}
