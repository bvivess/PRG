package ACT8_0C2;

/**
 *
 * @author winadmin
 */
public class Rectangle extends Coloreador implements FiguraGeometrica{
    double amplada, alcada;
    
    Rectangle(String color, double amplada, double alcada) {
        super(color);
        this.amplada = amplada;
        this.alcada = alcada;
    }
    
    // Implementació del mètode de 'FiguraGeometrica'
    @Override
    public double calculaArea() {
        return amplada * alcada;
    }
    
    @Override
    public double calculaPerimetre() {
        return 2 * (amplada + alcada);
    }

    @Override
    public int calculaNCostats() {
        return 4;
    }
    
    @Override
    public String toString() {  // si es poden implementar els mètodes d''Object'
        return "Color: " + this.color + " Amplada: " + this.amplada + " Alçada: " + this.alcada;
    }
}
