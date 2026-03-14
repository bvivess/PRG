package ACT8_0C1;

import ACT8_0B.*;

/**
* Forma geomètrica: Rombe
 * @author T.Vives
 */
public class Rombe implements FiguraGeometrica, Coloreador {
    // Atributs
    private double base, apotema;

    // Constructor
    public Rombe(double base, double apotema) {
        this.base = base;
        this.apotema = apotema;
    }

    // Implementació del mètode de 'FiguraGeometrica'
    @Override
    public double calculaArea() {
        return (5 * this.calculaPerimetre() * apotema)  / 2;
    }
    
    @Override
    public double calculaPerimetre() {
        return 5 * base;
    }

    @Override
    public int calculaNCostats() {
        return 4;
    }  

    @Override
    public String toString() {
        return "Rombe{" + "color=" + this.color + ", base=" + this.base + ", apotema=" + this.apotema + '}';
    }
    
}
