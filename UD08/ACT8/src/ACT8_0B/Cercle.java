package ACT8_0B;


/**
 *
 * @author winadmin
 */
class Cercle implements FiguraGeometrica, Coloreador {
    String color;
    double radi;
    
    // Constructor
    public Cercle(String color, double radi) {
        this.color = color;
        this.radi = radi;
    }
    
    // Implementaci� del m�tode de 'FiguraGeometrica'
    @Override
    public double calculaArea() {
        return Math.PI * Math.pow(radi, 2);
    }

    @Override
    public double calculaPerimetre() {
        return Math.PI * 2 * radi;
    }
    
    @Override
    public int calculaNCostats() {
        return 0;
    }
    
    // Implementaci� del m�tode de 'Colorear'
    @Override
    public void aplicaColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {  // si es poden implementar els m�todes d''Object'
        return "Color: " + color + " Radi: " + radi;
    }
}
