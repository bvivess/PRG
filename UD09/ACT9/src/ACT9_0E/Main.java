package ACT9_0E;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crear un objecte de la classe Cercle
        Cercle cercle = new Cercle("Vermell",5.0);

        cercle.aplicarColor("Blau");
        System.out.println("Àrea del cercle: " + cercle._toString());
        System.out.println("Àrea del cercle: " + cercle.__toString());
        System.out.println(cercle.toString() + " Àrea del cercle: " + cercle.calcularArea()); 
    }
}
