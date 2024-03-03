package ACT10_0C;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        FiguraGeometrica cercle = new CercleFactory().CreateFiguraGeometrica(5.0);
        FiguraGeometrica rectangle = new RectangleFactory().CreateFiguraGeometrica(5.0,2.0);
        
        System.out.println(cercle.calculaArea());
        System.out.println(rectangle.calculaArea());
    }
    
}
