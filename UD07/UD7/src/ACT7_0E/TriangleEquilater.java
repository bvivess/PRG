package ACT7_0E;

/**
* Forma geom�trica: Triangle equil�ter
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

    // M�todes espec�fics
    /**
     * Calcula l'�rea de la forma geom�trica
     * @return double �rea
     */
    @Override
    public double calculaArea() {
        return (base * altura)  / 2;
    }
    
    /**
     * Calcula el per�metre de la forma geom�trica
     * @return double �rea
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
