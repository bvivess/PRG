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
        System.out.println("�rea: " + r.calcularArea() );
        System.out.println("Per�metre: " + r.calcularPerimetre() );
        
        System.out.println("Cercle " + c.getRadi() + ":");
        System.out.println("�rea: " + c.calcularArea() );
        System.out.println("Per�metre: " + c.calcularPerimetre() );
    }
    
}