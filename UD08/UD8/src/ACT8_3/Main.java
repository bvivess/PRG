package ACT8_3;

/**
 *
 * @author winadmin
 */
// Clase principal para probar el sistema
public class Main {
    public static void main(String[] args) {
        // Crear instancias de empleados
        // Empleat empleat = new Empleat("pere","martinez",1000); // -> no es pot instanciar
        EmpleatPerCompteAliena empleat1 = new EmpleatPerCompteAliena("Pere","March",2000);
        EmpleatPerComptePropia empleat2 = new EmpleatPerComptePropia("Joan", "Marcus", 15, 40);
        
        // Mostrar detalles de los empleados
        System.out.println( empleat1.toString());
        System.out.println( empleat2.toString());
        
        System.out.println("Comparació d'empleats: " + empleat1.equals(empleat2));
    }
}