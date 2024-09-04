package ACT6_0B;

/**
 * Forma geom�trica: Cercle
 * @author T.Vives
 */
public class Cercle {
    // Atributs
    private double radi;
    
    // Constructor
    public Cercle(double radi) {
        this.radi = radi;
    }
    
    // M�todes espec�fics
    /**
     * Calcula l'�rea de la forma geom�trica
     * @return double �rea
    */
    public double calcularArea() {
        return Math.PI * Math.pow(radi,2);
    }
    
    /**
     * Calcula el per�metre de la forma geom�trica
     * @return double �rea
    */    
    public double calcularPerimetre() {
        return 2 * (Math.PI + radi);
    }
    
    // Getters i Setters
    public double getRadi() {
        return radi;
    }

    public void setRadi(double radi) {
        this.radi = radi;
    }
    
    
}
