package ACT10_0A;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Empleat empleat = Empleat.getEmpleat("Maria", "Nadal");
        empleat = Empleat.getEmpleat("Josep", "Torres");
        
        System.out.println(empleat.toString());
    }
    
}
