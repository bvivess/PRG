package ACT6_0C;

/**
* Forma geomètrica: Rombe
 * @author T.Vives
 */
public class Rombe {
    // Atributs
    private double base;
    private double apotema;

    // Constructor
    public Rombe(double base, double apotema) {
        this.setBase(base);
        this.setApotema(apotema);
    }

    // Mètodes específics
    /**
     * Calcula l'àrea de la forma geomètrica
     * @return double àrea
     */
    public double calcularArea() {
        return (5 * this.calcularPerimetre() * this.apotema)  / 2;
    }
    
    /**
     * Calcula el perímetre de la forma geomètrica
     * @return double àrea
    */    
    public double calcularPerimetre() {
        return 5 * this.base;
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
