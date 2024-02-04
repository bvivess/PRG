package ACT9_1A;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Persona1
        Persona persona1 = new Persona("Joan","1234", null, null, null);
        
        // Persona2
        Persona persona2 = new Persona("Gemma",null, "Teclat2", null, null);
        
        // Persona3
        Persona persona3 = new Persona("Pere",null, null, "Emprempta3", null);
        
        // Persona4
        Persona persona4 = new Persona("Maria",null, null, null, "Rostre4");
        
        // Android
        Android android1 = new Android("Samsung", persona1,"1234", null, null);
        android1.setOnOff(true);
        
        Android android2 = new Android("Samsung", persona2,null, "Teclat2", null);
        android2.setOnOff(true);
        
        // IPhone8
        IPhone8 iphone8 = new IPhone8("Apple",persona3, null, "Emprempta3");
        iphone8.setOnOff(true);
        
        // IPhone10
        IPhone10 iphone10 = new IPhone10("Apple",persona4,null, null, "Rostre4");
        iphone10.setOnOff(true);
        
        // Validacions
        System.out.println("Android1: ");
        System.out.print("\t" + persona1.getNom() + " " + android1.validaPatrons(persona1) + " ");
        System.out.print("\t" + persona2.getNom() + " " + android1.validaPatrons(persona2) + " ");
        System.out.print("\t" + persona3.getNom() + " " + android1.validaPatrons(persona3) + " ");
        System.out.print("\t" + persona4.getNom() + " " + android1.validaPatrons(persona4) + " ");
        System.out.println("");
        System.out.println("Android2: ");
        System.out.print("\t" + persona1.getNom() + " " + android2.validaPatrons(persona1) + " ");
        System.out.print("\t" + persona2.getNom() + " " + android2.validaPatrons(persona2) + " ");
        System.out.print("\t" + persona3.getNom() + " " + android2.validaPatrons(persona3) + " ");
        System.out.print("\t" + persona4.getNom() + " " + android2.validaPatrons(persona4) + " ");
        System.out.println("");
        System.out.println("IPhone8: ");
        System.out.print("\t" + persona1.getNom() + " " + iphone8.validaPatrons(persona1) + " ");
        System.out.print("\t" + persona2.getNom() + " " + iphone8.validaPatrons(persona2) + " ");
        System.out.print("\t" + persona3.getNom() + " " + iphone8.validaPatrons(persona3) + " ");
        System.out.print("\t" + persona4.getNom() + " " + iphone8.validaPatrons(persona4) + " ");
        System.out.println("");
        System.out.println("IPhone10: ");
        System.out.print("\t" + persona1.getNom() + " " + iphone10.validaPatrons(persona1) + " ");
        System.out.print("\t" + persona2.getNom() + " " + iphone10.validaPatrons(persona2) + " ");
        System.out.print("\t" + persona3.getNom() + " " + iphone10.validaPatrons(persona3) + " ");
        System.out.print("\t" + persona4.getNom() + " " + iphone10.validaPatrons(persona4) + " ");
        System.out.println();

        System.out.println();
        android1.setOnOff(false);
        android2.setOnOff(false);
        iphone8.setOnOff(false);
        iphone10.setOnOff(false);
        
    }
}