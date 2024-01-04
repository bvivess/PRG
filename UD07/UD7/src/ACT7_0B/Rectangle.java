package ACT7_0B;

/**
 *
 * @author T.Vives
 */
public class Rectangle {
    // Atributs
    private double amplada;
    private double alcada;
    
    // Mètodes
    // Constructor
    public Rectangle(double amplada, double alcada) {
        this.amplada = amplada;
        this.alcada = alcada;
    }

    public double calcularArea() {
        return amplada * alcada;
    }
    
    public double calcularPerimetre() {
        return 2 * (amplada + alcada);
    }
    
    // Getters i Setters
    public double getAmplada() {
        return amplada;
    }

    public void setAmplada(double amplada) {
        this.amplada = amplada;
    }

    public double getAlcada() {
        return alcada;
    }

    public void setAlcada(double alcada) {
        this.alcada = alcada;
    }
    
}



