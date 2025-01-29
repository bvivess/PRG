package ACT6_0C;

/**
* Forma geomètrica: Rectangle
 * @author T.Vives
 */
public class Rectangle {
    // Atributs
    private double amplada;
    private double alcada;
    
    // Constructor
    public Rectangle(double amplada, double alcada) {
        this.amplada = amplada;
        this.alcada = alcada;
    }
    
    // Mètodes específics
    /**
     * Calcula l'àrea de la forma geomètrica
     * @return double àrea
    */
    public double calcularArea() {
        return amplada * alcada;
    }
    
    /**
     * Calcula el perímetre de la forma geomètrica
     * @return double àrea
    */ 
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



