package ACT10_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Persones
            List<Persona> persones = new ArrayList<>();
            persones.add(new Persona("Joan",23));
            persones.add(new Persona("Gemma",30));
            persones.add(new Persona("Pere",36));
            persones.add(new Persona("Maria",18));

            // Mòduls
            Map<String, Modul> moduls = new HashMap<>();
            moduls.put("PRG", new Modul("Programació",7, persones));
            moduls.put("GBD", new Modul("Gestió de Base de Dades",8, persones));
            moduls.put("LLM", new Modul("Llenguatge de Marques",4, persones));
            moduls.put("SI", new Modul("Sistemes d'Informació",7, persones));
            moduls.put("ED", new Modul("Entorns de Desenvolupament",3, persones));

            for (String k : moduls.keySet()) {
                Modul modul = moduls.get(k);
                System.out.println("Clau: " + k + ", Valor: " + modul.toString());
            }

            // Del mòdul amb clau="PRG", Nom del mòdul i a continuació Nom de la tercera persona matriculada
            System.out.println(moduls.get("PRG").nom + ": " + moduls.get("PRG").matricula.get(2).nom );

            // Del mòdul amb clau="GBD", Nom del mòdul i a continuació Total de persones matriculades
            System.out.println(moduls.get("GBD").nom + ": " + moduls.get("GBD").matricula.size());

            // Del mòdul amb clau="LLM", Nom del mòdul i a continuació: Llista totes les persones matriculades
            System.out.println(moduls.get("LLM").nom + ":");
            for (Persona p : moduls.get("LLM").matricula) {
                System.out.print("\t" + p.nom);
            }
            System.out.print("\n");
        } catch (Exception e) {
            System.out.println("S'ha produït un error: " + e.getMessage());
        }
    }
}
