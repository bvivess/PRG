package ACT5_0B;

/**
 *
 * @author T.Vives
 */
public class Rectangle {
    // Atributs
    public double amplada;
    public double alcada;
    
    // M�todes
    public double calcularArea() {
        return amplada * alcada;
    }
    
    public double calcularPerimetre() {
        return 2 * (amplada + alcada);
    }
}



