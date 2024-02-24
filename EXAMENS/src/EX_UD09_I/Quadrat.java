package EX_UD09_I;

/** Quadrat: Figura geomètrica de 4 costats iguals
 *
 * @author winadmin
 */
public class Quadrat extends FiguraBase  {
    private double costat1;

    public Quadrat(String color, double costat1) {
        super(color);
        this.costat1 = costat1;
    }
    
    @Override
    public double calculaArea() {
        return Math.pow(costat1,2);
    }

    @Override
    public double calculaPerimetre() {
        return costat1 * 4;
    }

    @Override
    public double calculaNCostats() {
        return 4;
    }
    
    
     
    @Override
    public String toString() {
        return "Quadrat: costat:" + this.costat1 + ", " + super.toString() + ", Àrea: " + this.calculaArea();
    }
}
