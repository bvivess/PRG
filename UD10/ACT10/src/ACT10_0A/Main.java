package ACT10_0A;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Empleat empleat = Empleat.getEmpleat("Immaculada", "Solsona");
        empleat = Empleat.getEmpleat("Esperança", "Torres");  // Aquesta instància no es generarà
        
        System.out.println(empleat.toString());
    }
    
}
