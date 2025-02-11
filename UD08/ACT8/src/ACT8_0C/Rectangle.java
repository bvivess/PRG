package ACT8_0C;

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
    
    // Implementaci� del m�tode de 'FiguraGeometrica'
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
    
    // Implementaci� del m�tode de 'Coloreador'
    @Override
    public void aplicaColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {  // si es poden implementar els m�todes d''Object'
        return "Color: " + this.color + " Amplada: " + this.amplada + " Al�ada: " + this.alcada;
    }
}
