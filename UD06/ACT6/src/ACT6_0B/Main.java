package ACT6_0B;

/**
 *
 * @author T.Vives
 */
public class Main {

   public static void main(String[] args) {
        Rectangle r = new Rectangle();
        // Cercle ...

        r.alcada = 20;
        r.amplada = 2;
        System.out.println("Àrea: " + r.calcularArea() );
        System.out.println("Perímetre: " + r.calcularPerimetre() );
    }
    
}