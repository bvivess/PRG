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
    public double calcularArea() {
        return (5 * calcularPerimetre() * apotema)  / 2;
    }
    
    public double calcularPerimetre() {
        return 5 * base;
    }
    
}
