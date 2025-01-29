package ACT6_0C;

/**
* Forma geom�trica: Rectangle
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
    
    // M�todes espec�fics
    /**
     * Calcula l'�rea de la forma geom�trica
     * @return double �rea
    */
    public double calcularArea() {
        return amplada * alcada;
    }
    
    /**
     * Calcula el per�metre de la forma geom�trica
     * @return double �rea
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



