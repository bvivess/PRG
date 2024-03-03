package ACT10_0C;

/**
 *
 * @author winadmin
 */
public class CercleFactory extends FiguraGeometricaFactory {

    @Override
    public FiguraGeometrica CreateFiguraGeometrica(double... param) {
        return new Cercle(param[0]);
    }
    
}
