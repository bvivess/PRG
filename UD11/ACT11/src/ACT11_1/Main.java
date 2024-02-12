package ACT11_1;

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
        // Mòduls DAW
        Persona persona1 = new Persona("Joan",23);
        Persona persona2 = new Persona("Gemma",30);
        Persona persona3 = new Persona("Pere",36);
        Persona persona4 = new Persona("Maria",18);
        
        List<Persona> persones = new ArrayList<>();
        persones.add(persona1);
        persones.add(persona2);
        persones.add(persona3);
        persones.add(persona4);
           
        Modul modul1 = new Modul("Programació",7, persones);
        Modul modul2 = new Modul("Gestió de Base de Dades",8, persones);
        Modul modul3 = new Modul("Llenguatge de Marques",4, persones);
        Modul modul4 = new Modul("Sistemes d'Informació",7, persones);
        Modul modul5 = new Modul("Entorns de Desenvolupament",3, persones);
         
        Map<Integer, Modul> moduls = new HashMap<>();
        moduls.put(1, modul1);
        moduls.put(2, modul2);
        moduls.put(3, modul3);
        moduls.put(4, modul4);
        moduls.put(5, modul5);
        
        // Del mòdul amb clau=1, Nom del mòdul i a continuació Nom de la tercera persona matriculada
        System.out.println(moduls.get(1).nom + ": " + moduls.get(1).matricula.get(2).nom );
        
        // Del mòdul amb clau=2, Nom del mòdul i a continuació Total de persones matriculades
        System.out.println(moduls.get(2).nom + ": " + moduls.get(2).matricula.size());
        
        // Del mòdul amb clau=3, Nom del mòdul i a continuació: Llista totes les persones matriculades
        System.out.println(moduls.get(3).nom + ":");
        for (Persona p : moduls.get(3).matricula) {
            System.out.print("\t" + p.nom);
        }
        System.out.print("\n");
    }
}
