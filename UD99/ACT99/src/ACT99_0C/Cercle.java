package ACT99_0C;

/**
 *
 * @author winadmin
 */
class Cercle implements FiguraGeometrica {
    double radi;
    
    // Constructor
    public Cercle(double radi) {
        this.radi = radi;
    }
    
    public Cercle() {
        
    }
    
    // Implementació del mètode de 'Figura'
    @Override
    public double calculaArea() {
        return Math.PI * Math.pow(radi, 2);
    }

    public void setRadi(double radi) {
        this.radi = radi;
    }
}
