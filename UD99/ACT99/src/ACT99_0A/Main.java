package ACT99_0A;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Empleat empleat;
        
        empleat = Empleat.getEmpleat("Immaculada", "Solsona");
        empleat = Empleat.getEmpleat("Esperanša", "Torres");  // Aquesta instÓncia no s'implementarÓ
        
        System.out.println(empleat.toString());
    }
    
}
