package ACT8_0Z;

/** Classe principal per demostrar el polimorfisme
 * 
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crea instàncies de diferents empleats
        Empleat empleat1 = new EmpleatAssalariat("Pere","March",2000);
        Empleat empleat2 = new EmpleatAutonom("Joan", "Marcus", 15, 40);

        // Realitza operacions en cada empleat
        System.out.println(empleat1.toString() + " " + calculaSalari(empleat1));
        System.out.println("------------------------");
        System.out.println(empleat2.toString() + " " +  calculaSalari(empleat2));
    }

    // Realitza operacions en l'empleat
    private static double calculaSalari(Empleat e) {

        return e.calculaSalari();
    }
}