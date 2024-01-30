package ACT9_0A;


/**
 *
 * @author winadmin
 */
class Cercle implements FiguraGeometrica {
    private double radi;

    // Constructor
    public Cercle(double radi) {
        this.radi = radi;
    }

    // Implementació del mètode de la interficie per a calcular l'àrea del cercle
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radi, 2);
    }
}
