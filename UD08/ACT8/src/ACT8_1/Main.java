package ACT8_1;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Persona1
        Persona persona1 = new Persona("Joan","1234", null, null, null);
        // Persona2
        Persona persona2 = new Persona("Gemma", null, "Teclat2", null, null);
        // Persona3
        Persona persona3 = new Persona("Pere", null, null, "Emprempta3", null);
        // Persona4
        Persona persona4 = new Persona("Maria", null, null, null, "Rostre4");
        
        // Android
        Android android1 = new Android("Samsung", persona1,"1234", null, null);
        // Android
        Android android2 = new Android("Xiaomi", persona2, null, "Teclat2", null);
        // IPhone8
        IPhone8 iphone8 = new IPhone8("Apple", persona3, null, "Emprempta3");
        // IPhone10
        IPhone10 iphone10 = new IPhone10("Apple", persona4, null, null, "Rostre4");

        // Encenent dispositius
        
        System.out.println("Encenent " + android1.toString() + "...");
        android1.on();
        System.out.println("Encenent " + android2.toString() + "...");
        android2.on();
        System.out.println("Encenent " + iphone8.toString() + "...");
        iphone8.on();
        System.out.println("Encenent " + iphone10.toString() + "...");  
        iphone10.on();
        
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

        // Apagant dispositius
        System.out.println();
        System.out.println("Apagant1 " + android1.toString() + "...");
        android1.off();
        System.out.println("Apagant " + android2.toString() + "...");
        android2.off();
        System.out.println("Apagant " + iphone8.toString() + "...");
        iphone8.on();
        System.out.println("Apagant " + iphone10.toString() + "...");
        iphone10.on();
    }
}