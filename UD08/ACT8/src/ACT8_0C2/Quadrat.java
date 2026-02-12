package ACT8_0C2;

/**
 *
 * @author Administrador
 */
public class Quadrat extends Coloreador implements FiguraGeometrica {
    private double costat;

    public Quadrat(String color, double costat) {
        super(color);
        this.costat = costat;
    }

    // Implementació del mètode de 'FiguraGeometrica'
    @Override
    public double calculaArea() {
        return Math.pow(this.costat,2);
    }

    @Override
    public double calculaPerimetre() {
        return this.costat * 4;
    }

    @Override
    public int calculaNCostats() {
        return 4;
    }

}
