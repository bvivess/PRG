package ACT8_0B;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crear un objecte de la classe Cercle
        Cercle cercle = new Cercle("Vermell",5.0);

        cercle.aplicaColor("Blau");
        System.out.println("�rea del cercle: " + cercle.toString());
        System.out.println(cercle.toString() + " �rea del cercle: " + cercle.calculaArea()); 
    }
}
