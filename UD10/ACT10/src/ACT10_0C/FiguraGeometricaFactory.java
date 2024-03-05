package ACT10_0C;

/**
 *
 * @author winadmin
 */
public abstract class FiguraGeometricaFactory {
    
    // 'FiguraGeometricaFactory' passa a ser una classe abstracta 
    // 'CercleFactory', 'RectangleFactory' extenen 'FiguraGeometricaFactory'
    public abstract FiguraGeometrica CreateFiguraGeometrica(double ... param);
    
}
