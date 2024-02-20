package EX_UD09;

/** Rectangle: Figura geomètrica de 2 costats desiguals
 *
 * @author winadmin
 */
public class Rectangle extends FiguraBase {
    private double costat1;
    private double costat2;

    public Rectangle(String color, double costat1, double costat2) {
        super(color);
        this.costat1 = costat1;
        this.costat2 = costat2;
    }
    
    @Override
    public double calculaArea() {
        return this.costat1 * this.costat2;
    }
    
    @Override
    public double calculaPerimetre() {
        return (costat1 * 2) + (costat2 * 2);
    }

    @Override
    public double calculaNCostats() {
        return 4;
    }
    
    @Override
    public String toString() {
        return "Rectangle: costat1: " + this.costat1 + ", costat2: " + this.costat2  + ", " + super.toString() + ", Àrea: " + this.calculaArea();
    }
}
