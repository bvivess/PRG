package ACT6_0C;

/**
 *
 * @author T.Vives
 */
public class Main {

   public static void main(String[] args) {
        Rectangle r = new Rectangle(20.0,2.0);
        Cercle c = new Cercle(20.0);
        // Cercle ...

        System.out.println("Rectancle " + r.getAlcada() + " " + r.getAmplada() + ":");
        System.out.println("Àrea: " + r.calcularArea() );
        System.out.println("Perímetre: " + r.calcularPerimetre() );
        
        System.out.println("Cercle " + c.getRadi() + ":");
        System.out.println("Àrea: " + c.calcularArea() );
        System.out.println("Perímetre: " + c.calcularPerimetre() );
    }
    
}