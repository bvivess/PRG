package ACT8_0D;

import ACT8_0A.*;

/**
 *
 * @author T:Vives
 * 
 * Exemple de Herència Simple
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
        
        //Persona p = p1;
        //System.out.println((p == p1?;true;false));
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.equals(p2));
    }
}
