package ACT6_0C;

/**
* Forma geomètrica: Triangle equilàter
 * @author T.Vives
 */
public class TriangleEquilater {
    // Atributs
    public double base;
    public double altura;
    
    // Constructor
    public TriangleEquilater(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Mètodes específics
    /**
     * Calcula l'àrea de la forma geomètrica
     * @return double àrea
     */
    public double calcularArea() {
        return (this.base * this.altura)  / 2;
    }
    
    /**
     * Calcula el perímetre de la forma geomètrica
     * @return double àrea
    */     
    public double calcularPerimetre() {
        return 3 * this.base;
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
