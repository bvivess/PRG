package ACT10_0B;

/**
 *
 * @author winadmin
 */
public class FiguraGeometricaFactory {
    public FiguraGeometrica CreateFiguraGeometrica(String tipus, double ... param) {
        if (tipus.equalsIgnoreCase("Cercle"))
            return new Cercle(param[0]);  // param[0]: radi
        else if (tipus.equalsIgnoreCase("Rectangle"))
            return new Rectangle(param[0], param[1]);  // param[0]: amplada; param[1]: alçada
        else
            return null;
    }
    
}
