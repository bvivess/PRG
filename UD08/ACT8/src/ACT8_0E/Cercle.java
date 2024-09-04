package ACT8_0E;


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
    
    // Implementaci� del m�tode de 'Figura'
    @Override
    public double calculaArea() {
        return Math.PI * Math.pow(radi, 2);
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
