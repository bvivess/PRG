package ACT5_0B;

/**
 *
 * @author T.Vives
 */
public class Cercle {
    // Atributs
    public double radi;
    
    // M�todes
    public double calcularArea() {
        return Math.PI * Math.pow(radi,2);
    }
    
    public double calcularPerimetre() {
        return 2 * (Math.PI + radi);
    }
}
