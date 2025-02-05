package ACT7_0E;

/**
* Forma geom�trica: Rectangle
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
    
    // M�todes espec�fics
    /**
     * Calcula l'�rea de la forma geom�trica
     * @return double �rea
    */
    @Override
    public double calculaArea() {
        return amplada * alcada;
    }
    
    /**
     * Calcula el per�metre de la forma geom�trica
     * @return double �rea
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



