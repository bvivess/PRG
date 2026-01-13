package ACT6_0C;

/**
* Forma geomètrica: Quadrat
 * @author T.Vives
 */
public class Quadrat {
    // Atributs
    private double costat;

    // Constructor
    public Quadrat(double costat) {
        this.costat = costat;
    }
    
    // Mètodes específics
    /**
     * Calcula l'àrea de la forma geomètrica
     * @return double àrea
    */
    public double calcularArea() {
        return Math.PI * Math.pow(this.costat,2);
    }
 
    /**
     * Calcula el perímetre de la forma geomètrica
     * @return double àrea
    */ 
    public double calcularPerimetre() {
        return 4 * this.costat;
    }
    
    // Getters i Setters
    public double getCostat() {
        return costat;
    }

    public void setCostat(double costat) {
        this.costat = costat;
    }
    
}
