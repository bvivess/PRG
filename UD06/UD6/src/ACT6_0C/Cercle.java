package ACT6_0C;

/**
 * Forma geomètrica: Cercle
 * @author T.Vives
 */
public class Cercle {
    // Atributs
    private double radi;
    
    // Constructor
    public Cercle(double radi) {
        this.radi = radi;
    }
    
    // Mètodes específics
    /**
     * Calcula l'àrea de la forma geomètrica
     * @return double àrea
    */
    public double calcularArea() {
        return Math.PI * Math.pow(this.radi,2);
    }
    
    /**
     * Calcula el perímetre de la forma geomètrica
     * @return double àrea
    */    
    public double calcularPerimetre() {
        return 2 * (Math.PI + this.radi);
    }
    
    // Getters i Setters
    public double getRadi() {
        return radi;
    }

    public void setRadi(double radi) {
        this.radi = radi;
    }
    
    
}
