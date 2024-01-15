package ACT8_0D;

/**
 *
 * @author T:Vives
 * 
 * @Override
 *      toString()
 *      equals()
 * 
 */
public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona ("Joan",10);
        Persona p2 = new Persona ("Pere",10);
        Persona p3 = p1; // iguala referències, no continguts
        
        System.out.println(p1.toString());  // estudiant.mostraEstudiant()
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println("p1-p2: " + p1.equals(p2));
        System.out.println("p1-p3: " + p1.equals(p3));

        Estudiant e1 = new Estudiant ("Joan",10,"DAW");
        Estudiant e2 = new Estudiant ("Pere",10,"DAW");
        Estudiant e3 = e1; // iguala referències, no continguts
        
        System.out.println(e1.toString());  // estudiant.mostraEstudiant()
        System.out.println(e2.toString());
        System.out.println("e1-e2: " + e1.equals(e2));
        System.out.println("e1-e3: " + e1.equals(e3));

    }
}
