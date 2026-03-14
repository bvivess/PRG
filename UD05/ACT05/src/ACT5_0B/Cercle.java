package ACT5_0B;

/**
 *
 * @author T.Vives
 */
public class Cercle {
    // Atributs
    public double radi;
    
    // Mètodes
    public double calculaArea() {
        return Math.PI * Math.pow(radi,2);
    }
    
    public double calculaPerimetre() {
        return 2 * (Math.PI + radi);
    }
}
