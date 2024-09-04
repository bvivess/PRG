package ACT8_2A;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> persones = new ArrayList<Persona>();
        ArrayList<Telefon> telefons = new ArrayList<Telefon>();
        
        // Persones
        carregaPersones(persones);
        
        // Telefons
        carregaTelefons(telefons, persones);
        
        // Encenent dispositius
        encenDispositius(telefons);
        
        // Validacions
        validaDispositius(telefons, persones);

        // Apagant dispositius
        apagaDispositius(telefons);
    }
    
    private static void carregaPersones(ArrayList<Persona> persones) {
        Persona persona;
        
        persona = new Persona("Joan","1234", null, null, null);
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
    }
    
    private static void carregaTelefons(ArrayList<Telefon> telefons, ArrayList<Persona> persones) {
        Telefon telefon;
        telefon = new Android("Samsung", persones.get(0),"1234", null, null);
        telefons.add(telefon);
        // Android
        telefon = new Android("Xiaomi", persones.get(1),null, "Teclat2", null);
        telefons.add(telefon);
        // IPhone8
        telefon = new IPhone8("Apple",persones.get(2), null, "Emprempta3");
        telefons.add(telefon);
        // IPhone10
        telefon = new IPhone10("Apple",persones.get(3),null, null, "Rostre4");
        telefons.add(telefon);
    }
    
    private static void validaDispositius(ArrayList<Telefon> telefons, ArrayList<Persona> persones) {
        for (Persona p : persones) {
            for (Telefon t : telefons) {
                System.out.print("\t" + p.getNom() + " " + t.validaPatrons(p) + " ");
            }
            System.out.print("\n" );
        }
    }
    
    private static void encenDispositius(ArrayList<Telefon> telefons) {
        for (Telefon t : telefons) {
            System.out.println("Apagant " + t.toString() + "...");
            t.on();
        }
    }
    
    private static void apagaDispositius(ArrayList<Telefon> telefons) {
        for (Telefon t : telefons) {
            System.out.println("Apagant " + t.toString() + "...");
            t.off();
        }
    }
}