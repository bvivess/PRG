package ACT8_0E;

/**
 *
 * @author winadmin
 */
public class Rectangle implements Coloreador, FiguraGeometrica {
    String color;
    double amplada, alcada;
    
    Rectangle(String color, double amplada, double alcada) {
        this.color = color;
        this.amplada = amplada;
        this.alcada = alcada;
    }
    
    @Override
    public void aplicaColor(String color) {
        this.color = color;
    }

    @Override
    public double calculaArea() {
        return amplada * alcada;
    }
    
    @Override
    public String toString() {  // si es poden implementar els mètodes d''Object'
        return "Color: " + color + " Amplada: " + amplada + " Alçada: " + alcada;
    }
}
