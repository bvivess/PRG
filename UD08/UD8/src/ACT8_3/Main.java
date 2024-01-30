package ACT8_3;

/** Clase principal para probar el sistema
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crear instàncies d'empleats
        // Empleat empleat = new Empleat("pere","Martinez",1000); // -> no es pot instanciar
        EmpleatPerCompteAliena empleat1 = new EmpleatPerCompteAliena("Pere","March",2000);
        EmpleatPerComptePropia empleat2 = new EmpleatPerComptePropia("Joan", "Marcus", 15, 40);
        
        // Mostrar detalls dels empleats
        System.out.println( empleat1.toString());
        System.out.println( empleat2.toString());
        
        System.out.println("Comparació d'empleats: " + empleat1.equals(empleat2));
    }
}