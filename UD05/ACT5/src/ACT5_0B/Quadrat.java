package ACT5_0B;

/**
 *
 * @author T.Vives
 */
public class Quadrat {
    // Atributs
    public double costat;
    
    // M�todes
    public double calcularArea() {
        return Math.PI * Math.pow(costat,2);
    }
    
    public double calcularPerimetre() {
        return 4 * costat;
    }
    
}
