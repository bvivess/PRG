package EX_UD09;

/** Triangle equil�ter: Figura geom�trica de 3 costats iguals
 *
 * @author winadmin
 */
public class TriangleEquilater extends FiguraBase {
    private double costat1;

    public TriangleEquilater(double costat1, String color) {
        super(color);
        this.costat1 = costat1;
    }
    
    @Override
    public double calculaArea() {
        return (Math.sqrt(3) / 4) * Math.pow(this.costat1, 2);
    }
    
    @Override
    public double calculaPerimetre() {
        return (costat1 * 3);
    }

    @Override
    public double calculaNCostats() {
        return 3;
    }
    
    @Override
    public String toString() {
        return "Triangle Equil�ter: costat1: " + this.costat1 + ", " + super.toString()  + ", �rea: " + this.calculaArea();
    }
    
}
