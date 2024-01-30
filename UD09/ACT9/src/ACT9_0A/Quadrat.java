package ACT9_0A;

/**
 *
 * @author winadmin
 */
class Quadrat implements FiguraGeometrica {
    private double costat;
    
    // Constructor
    public Quadrat(double costat) {
        this.costat = costat;
    }
  
    // No getters ni setters

    // Implementació del mètode de la interficie per a calcular l'àrea del quadrat
    @Override
    public double calculaArea() {
        return Math.pow(costat, 2);
    }

    @Override
    public double calculaPerimetre() {
        return 0;
    }

    @Override
    public int calculaNCostats() {
        return 4;
    }
      
}
