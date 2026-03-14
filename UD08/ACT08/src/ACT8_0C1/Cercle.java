package ACT8_0C1;

import ACT8_0B.*;


/**
 *
 * @author winadmin
 */
class Cercle implements FiguraGeometrica, Coloreador {
    double radi;
    
    // Constructor
    public Cercle(double radi) {
        this.radi = radi;
    }
    
    // Implementació del mètode de 'FiguraGeometrica'
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
    
    @Override
    public String toString() {  // si es poden implementar els mètodes d''Object'
        return "Color: " + this.color + " Radi: " + this.radi;
    }
}
