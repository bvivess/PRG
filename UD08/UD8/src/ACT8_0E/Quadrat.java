package ACT8_0E;

/**
 *
 * @author Administrador
 */
public class Quadrat extends FiguraGeometrica {
    private double costat;

    public Quadrat(double costat, String color) {
        super(color);
        this.costat = costat;
    }

    @Override
    public double calculaArea() {
        return Math.pow(this.costat,2);
    }

    @Override
    double calculaPerimetre() {
        return this.costat * 4;
    }

    @Override
    int calculaNCostats() {
        return 4;
    }

    
    
}
