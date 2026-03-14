package ACT7_0E;

/**
* Forma geomètrica: Rombe
 * @author T.Vives
 */
public class Rombe extends FiguraGeometrica {
    // Atributs
    private double base;
    private double apotema;

    // Constructor
    public Rombe(String color, double base, double apotema) {
        super(color);
        this.base = base;
        this.apotema = apotema;
    }

    // Mètodes específics
    /**
     * Calcula l'àrea de la forma geomètrica
     * @return double àrea
     */
    @Override
    public double calculaArea() {
        return (5 * this.calculaPerimetre() * apotema)  / 2;
    }

    @Override
    int calculaNCostats() {
        return 4;
    }
    
    /**
     * Calcula el perímetre de la forma geomètrica
     * @return double àrea
    */    
    @Override
    public double calculaPerimetre() {
        return 5 * base;
    }
    
    // Getters i Setters
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getApotema() {
        return apotema;
    }

    public void setApotema(double apotema) {
        this.apotema = apotema;
    }
    
}
