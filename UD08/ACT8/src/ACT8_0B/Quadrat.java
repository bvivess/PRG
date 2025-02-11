package ACT8_0B;

/**
 *
 * @author Administrador
 */
public class Quadrat implements FiguraGeometrica, Coloreador {
    String color;
    private double costat;

    public Quadrat(String color, double costat) {
        this.color = color;
        this.costat = costat;
    }

    // Implementaci� del m�tode de 'FiguraGeometrica'
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

    // Implementaci� del m�tode de 'Coloreador'
    @Override
    public void aplicaColor(String color) {
        this.color = color;
    }
}
