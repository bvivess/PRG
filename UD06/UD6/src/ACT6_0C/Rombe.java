package ACT6_0C;

/**
* Forma geom�trica: Rombe
 * @author T.Vives
 */
public class Rombe {
    // Atributs
    private double base;
    private double apotema;

    // Constructor
    public Rombe(double base, double apotema) {
        this.base = base;
        this.apotema = apotema;
    }

    // M�todes espec�fics
    /**
     * Calcula l'�rea de la forma geom�trica
     * @return double �rea
     */
    public double calcularArea() {
        return (5 * calcularPerimetre() * apotema)  / 2;
    }
    
    /**
     * Calcula el per�metre de la forma geom�trica
     * @return double �rea
    */    
    public double calcularPerimetre() {
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
