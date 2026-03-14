package ACT5_0B;

/**
 *
 * @author T.Vives
 */
public class Rectangle {
    // Atributs
    public double amplada;
    public double alcada;
    
    // Mètodes
    public double calculaArea() {
        return amplada * alcada;
    }
    
    public double calculaPerimetre() {
        return 2 * (amplada + alcada);
    }
}



