package ACT9_0E;

/**
 *
 * @author winadmin
 */
public class Rectangle implements Coloreador, Figura {
    String color;
    double amplada, alcada;
    
    Rectangle(String color, double amplada, double alcada) {
        this.color = color;
        this.amplada = amplada;
        this.alcada = alcada;
    }
    
    @Override
    public void aplicarColor(String color) {
        this.color = color;
    }

    @Override
    public double calcularArea() {
        return amplada * alcada;
    }
    
    @Override
    public String toString() {  // si es poden implementar els mètodes d''Object'
        return "Color: " + color + " Amplada: " + amplada + " Alçada: " + alcada;
    }
}
