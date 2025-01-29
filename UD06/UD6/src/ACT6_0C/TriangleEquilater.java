package ACT6_0C;

/**
* Forma geom�trica: Triangle equil�ter
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

    // M�todes espec�fics
    /**
     * Calcula l'�rea de la forma geom�trica
     * @return double �rea
     */
    public double calcularArea() {
        return (base * altura)  / 2;
    }
    
    /**
     * Calcula el per�metre de la forma geom�trica
     * @return double �rea
    */     
    public double calcularPerimetre() {
        return 3 * base;
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
