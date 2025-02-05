package ACT7_0E;

/**
* Forma geomètrica: Triangle equilàter
 * @author T.Vives
 */
public class TriangleEquilater extends FiguraGeometrica {
    // Atributs
    public double base;
    public double altura;
    
    // Constructor
    public TriangleEquilater(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    // Mètodes específics
    /**
     * Calcula l'àrea de la forma geomètrica
     * @return double àrea
     */
    @Override
    public double calculaArea() {
        return (base * altura)  / 2;
    }
    
    /**
     * Calcula el perímetre de la forma geomètrica
     * @return double àrea
    */
    @Override
    public double calculaPerimetre() {
        return 3 * base;
    }

    @Override
    int calculaNCostats() {
        return 3;
    }
 
    // Getters i Setters

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
}
