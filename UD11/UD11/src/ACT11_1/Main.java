package ACT11_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Persona> persones = new ArrayList<>();
        ArrayList<Telefon> telefons = new ArrayList<>();

        carregaPersones(persones);
        carregaTelefons(telefons, persones);

        encenDispositius(telefons);
        validaDispositius(telefons, persones);
        validaPersones(telefons, persones);
        apagaDispositius(telefons);
    }

    private static void carregaPersones(ArrayList<Persona> persones) {
        // Patrons
        HashMap<TipusPatro, String> patrons1 = new HashMap<>(); patrons1.put(TipusPatro.CODIPIN, "CodiPin1");
        HashMap<TipusPatro, String> patrons2 = new HashMap<>(); patrons2.put(TipusPatro.TECLAT, "Teclat2");
        HashMap<TipusPatro, String> patrons3 = new HashMap<>(); patrons3.put(TipusPatro.EMPREMTA, "Emprempta3");
        HashMap<TipusPatro, String> patrons4 = new HashMap<>(); patrons4.put(TipusPatro.ROSTRE, "Rostre1");
        // Persones
        persones.add(new Persona("Joan", patrons1));
        persones.add(new Persona("Gemma", patrons2));
        persones.add(new Persona("Pere", patrons3));
        persones.add(new Persona("Maria", patrons4));
    }

    private static void carregaTelefons(ArrayList<Telefon> telefons, ArrayList<Persona> persones) {
        // Patrons
        HashMap<TipusPatro, String> patrons1 = new HashMap<>(); patrons1.put(TipusPatro.CODIPIN, "CodiPin1");
        HashMap<TipusPatro, String> patrons2 = new HashMap<>(); patrons2.put(TipusPatro.TECLAT, "Teclat2");
        HashMap<TipusPatro, String> patrons3 = new HashMap<>(); patrons3.put(TipusPatro.EMPREMTA, "Emprempta3");
        HashMap<TipusPatro, String> patrons4 = new HashMap<>(); patrons4.put(TipusPatro.ROSTRE, "Rostre1");
        // Telefons
        telefons.add(new Android("Samsung", persones.get(0),patrons1));
        telefons.add(new Android("Xiaomi", persones.get(1),patrons2));
        telefons.add(new IPhone8("Apple", persones.get(2),patrons3));
        telefons.add(new IPhone10("Apple", persones.get(3),patrons4));
    }

    private static void validaDispositius(ArrayList<Telefon> telefons, ArrayList<Persona> persones) {
        System.out.print("\n");
        for (Persona p : persones) {
            for (Telefon t : telefons) {
                System.out.print("\t" + p.getNom() + " " + t.validaPatrons(p) + " ");
            }
            System.out.print("\n");
        }
    }
    
    private static void validaPersones(ArrayList<Telefon> telefons, ArrayList<Persona> persones) {
        System.out.print("\n");
        for (Telefon t : telefons) {
            for (Persona p : persones) {
                System.out.print("\t" + p.getNom() + " " + p.validaPatrons(t) + " ");
            }
            System.out.print("\n");
        }
    }

    private static void encenDispositius(ArrayList<Telefon> telefons) {
        for (Telefon t : telefons) {
            System.out.println("Encenent " + t.toString() + "...");
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