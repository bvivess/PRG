package ACT8_0C2;

/**
* Forma geomètrica: Rombe
 * @author T.Vives
 */
public class Rombe extends Coloreador implements FiguraGeometrica {
    // Atributs
    private double base, apotema;

    // Constructor
    public Rombe(String color, double base, double apotema) {
        super(color);
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
        return "Rombe{" + "color=" + super.color + ", base=" + this.base + ", apotema=" + this.apotema + '}';
    }
    
}
