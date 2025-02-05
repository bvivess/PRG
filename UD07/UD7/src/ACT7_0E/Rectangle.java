package ACT7_0E;

/**
* Forma geomètrica: Rectangle
 * @author T.Vives
 */
public class Rectangle extends FiguraGeometrica {
    // Atributs
    private double amplada;
    private double alcada;
    
    // Constructor
    public Rectangle(String color, double amplada, double alcada) {
        super(color);
        this.amplada = amplada;
        this.alcada = alcada;
    }
    
    // Mètodes específics
    /**
     * Calcula l'àrea de la forma geomètrica
     * @return double àrea
    */
    @Override
    public double calculaArea() {
        return amplada * alcada;
    }
    
    /**
     * Calcula el perímetre de la forma geomètrica
     * @return double àrea
    */ 
    @Override
    public double calculaPerimetre() {
        return 2 * (amplada + alcada);
    }

    @Override
    int calculaNCostats() {
        return 4;
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



