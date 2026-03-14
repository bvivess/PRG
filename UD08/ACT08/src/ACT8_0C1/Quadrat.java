package ACT8_0C1;

import ACT8_0B.*;

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

    @Override
    public String toString() {
        return "Quadrat{" + "color=" + this.color + ", costat=" + this.costat + '}';
    }

}
