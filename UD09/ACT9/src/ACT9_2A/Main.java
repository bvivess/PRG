package ACT9_2A;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> persones = new ArrayList<Persona>();
        ArrayList<Telefon> telefons = new ArrayList<Telefon>();
               
        // Persona1
        Persona persona = new Persona("Joan","1234", null, null, null);
        persones.add(persona);
        
        // Persona2
        persona = new Persona("Gemma",null, "Teclat2", null, null);
        persones.add(persona);
        
        // Persona3
        persona = new Persona("Pere",null, null, "Emprempta3", null);
        persones.add(persona);
        
        // Persona4
        persona = new Persona("Maria",null, null, null, "Rostre4");
        persones.add(persona);
        
        // Android
        Telefon telefon = new Android("Samsung", persones.get(0),"1234", null, null);
        telefons.add(telefon);
        
        telefon = new Android("Xiaomi", persones.get(1),null, "Teclat2", null);
        telefons.add(telefon);
        
        // IPhone8
        telefon = new IPhone8("Apple",persones.get(2), null, "Emprempta3");
        telefons.add(telefon);
        
        // IPhone10
        telefon = new IPhone10("Apple",persones.get(3),null, null, "Rostre4");
        telefons.add(telefon);

        // Encenent dispositius
        System.out.print("\n");
        for (Telefon t : telefons) {
            t.setOnOff(true);
            System.out.println("Encenent " + t.toString() + "...");
        }

        // Validacions Telefon a Persona
        System.out.print("\n");
        for (Persona p : persones) {
            for (Telefon t : telefons) {
                System.out.print("\t" + p.getNom() + ": " + t.validaPatrons(p) + " ");
            }
            System.out.print("\n");
        }

        // Apagant dispositius
        System.out.print("\n");
        for (Telefon t : telefons) {
            t.setOnOff(false);
            System.out.println("Apagant " + t.toString() + "...");
        }
        
    }
}