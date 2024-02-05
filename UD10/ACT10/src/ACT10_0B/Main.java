package ACT10_0B;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        FiguraGeometricaFactory fg = new FiguraGeometricaFactory();
        FiguraGeometrica cercle = fg.CreateFiguraGeometrica("Cercle");
        
        FiguraGeometrica rectangle = fg.CreateFiguraGeometrica("Rectangle");
        
        cercle.calculaArea();
        rectangle.calculaArea();
    }
    
}
