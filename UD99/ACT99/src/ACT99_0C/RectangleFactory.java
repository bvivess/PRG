package ACT99_0C;

/**
 *
 * @author winadmin
 */
public class RectangleFactory extends FiguraGeometricaFactory{
    
    @Override
    public FiguraGeometrica CreateFiguraGeometrica(double... param) {
        return new Rectangle(param[0], param[1]);
    }
    
}
