package ACT10_0B;

/**
 *
 * @author winadmin
 */
public class Rectangle implements FiguraGeometrica {
    double amplada, alcada;
    
    public Rectangle(double amplada, double alcada) {
        this.amplada = amplada;
        this.alcada = alcada;
    }
    
    public Rectangle() {
        
    }
    @Override
    public double calculaArea() {
        return amplada * alcada;
    }
}
