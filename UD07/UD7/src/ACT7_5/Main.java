package ACT7_5;

/** Clase principal para probar el sistema
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crear instàncies d'empleats
        // Empleat empleat = new Empleat("pere","Martinez",1000); // -> no es pot instanciar
        EmpleatAssalariat empleat1 = new EmpleatAssalariat("Pere","March", 2000);
        EmpleatAutonom empleat2 = new EmpleatAutonom("Pere", "March", 15, 40);
        
        // Mostrar detalls dels empleats
        System.out.println( empleat1.toString());
        System.out.println( empleat2.toString());
        
        System.out.println( empleat1.equals(empleat2));
        
        System.out.println("Comparació d'empleats: " + empleat1.equals(empleat2));
    }
}