package ACT10_0A;

/**
 *
 * @author winadmin
 */
public class FiguraGeometricaFactory {
    public FiguraGeometrica CreateFiguraGeometrica(String type) {
        if (type.equalsIgnoreCase("Cercle"))
            return new Cercle();
        else if (type.equalsIgnoreCase("Rectangle"))
            return new Rectangle();
        else
            return null;
    }
    
}
