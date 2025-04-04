package ACT8_0B;

/**
* Forma geom�trica: Rombe
 * @author T.Vives
 */
public class Rombe implements FiguraGeometrica, Coloreador {
    // Atributs
    String color;
    private double base, apotema;

    // Constructor
    public Rombe(String color, double base, double apotema) {
        this.color = color;
        this.base = base;
        this.apotema = apotema;
    }

    // Implementaci� del m�tode de 'FiguraGeometrica'
    @Override
    public double calculaArea() {
        return (5 * this.calculaPerimetre() * apotema)  / 2;
    }
    
    @Override
    public double calculaPerimetre() {
        return 5 * base;
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
    public String toString() {
        return "Rombe{" + "color=" + this.color + ", base=" + this.base + ", apotema=" + this.apotema + '}';
    }
    
}
