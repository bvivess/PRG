package ACT9_0A;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Empleat empleat;
        
        empleat = Empleat.getEmpleat("Immaculada", "Solsona");
        empleat = Empleat.getEmpleat("Esperan�a", "Torres");  // Aquesta inst�ncia no s'implementar�
        
        System.out.println(empleat.toString());
    }
    
}
