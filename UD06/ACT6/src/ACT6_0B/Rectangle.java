package ACT6_0B;

/**
 *
 * @author T.Vives
 */
public class Rectangle {
    // Atributs
    public double amplada;
    public double alcada;
    
    // Mètodes
    public double calcularArea() {
        return amplada * alcada;
    }
    
    public double calcularPerimetre() {
        return 2 * (amplada + alcada);
    }
}



