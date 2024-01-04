package ACT7_0B;

/**
 *
 * @author T.Vives
 */
public class Cercle {
    // Atributs
    private double radi;
    
    // Mètodes
    // Constructor
    public Cercle(double radi) {
        this.radi = radi;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radi,2);
    }
    
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
