package ACT8_0D;

import ACT8_0A.*;

/**
 *
 * @author T:Vives
 * 
 * Exemple de Herčncia Simple
 *     Persona
 *        ^ 
 *        |
 *    Estudiant
 * 
 */
public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona ("Joan",10);
        Persona p2 = new Persona ("Pere",10);
        Persona p3 = p1; // iguala referčncies, no continguts
        
        System.out.println(p1.toString());  // estudiant.mostraEstudiant()
        System.out.println(p2.toString());
        System.out.println(p1.equals(p2));
        System.out.println(p3.equals(p1));

        Estudiant e1 = new Estudiant ("Joan",10,"DAW");
        Estudiant e2 = new Estudiant ("Pere",10,"DAW");
        Estudiant e3 = e1; // iguala referčncies, no continguts
        
        System.out.println(e1.toString());  // estudiant.mostraEstudiant()
        System.out.println(e2.toString());
        System.out.println(e1.equals(e2));
        System.out.println(e3.equals(e1));

    }
}
