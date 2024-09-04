package ACT7_3;

/** Clase principal para probar el sistema
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crear inst�ncies d'empleats
        // Empleat empleat = new Empleat("pere","Martinez",1000); // -> no es pot instanciar
        EmpleatAssalariat empleat1 = new EmpleatAssalariat("Pere","March",2000);
        EmpleatAutonom empleat2 = new EmpleatAutonom("Joan", "Marcus", 15, 40);
        
        // Mostrar detalls dels empleats
        System.out.println( empleat1.toString());
        System.out.println( empleat2.toString());
        
        System.out.println("Comparaci� d'empleats: " + empleat1.equals(empleat2));
    }
}