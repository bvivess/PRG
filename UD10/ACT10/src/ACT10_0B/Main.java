package ACT10_0B;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        FiguraGeometricaFactory figuraGeometrica = new FiguraGeometricaFactory();
        FiguraGeometrica cercle = figuraGeometrica.CreateFiguraGeometrica("Cercle", 5.0);
        
        FiguraGeometrica rectangle = figuraGeometrica.CreateFiguraGeometrica("Rectangle", 5.0, 2.0);
        
        System.out.println(cercle.calculaArea());
        System.out.println(rectangle.calculaArea());
    }
    
}
