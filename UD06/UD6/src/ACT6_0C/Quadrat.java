package ACT6_0C;

/**
* Forma geom�trica: Quadrat
 * @author T.Vives
 */
public class Quadrat {
    // Atributs
    private double costat;

    // Constructor
    public Quadrat(double costat) {
        this.costat = costat;
    }
    
    // M�todes espec�fics
    /**
     * Calcula l'�rea de la forma geom�trica
     * @return double �rea
    */
    public double calcularArea() {
        return Math.PI * Math.pow(costat,2);
    }
 
    /**
     * Calcula el per�metre de la forma geom�trica
     * @return double �rea
    */ 
    public double calcularPerimetre() {
        return 4 * costat;
    }
    
    // Getters i Setters
    public double getCostat() {
        return costat;
    }

    public void setCostat(double costat) {
        this.costat = costat;
    }
    
}
