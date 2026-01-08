package ACT5_0B;

/**
 *
 * @author T.Vives
 */
public class Rombe {
    // Atributs
    public double base;
    public double apotema;
    
    // Mètodes
    public double calculaArea() {
        return (5 * calculaPerimetre() * apotema)  / 2;
    }
    
    public double calculaPerimetre() {
        return 5 * base;
    }
    
}
