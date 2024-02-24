package EX_UD09_I;

/** Figura geomètrica base
 *
 * @author winadmin
 */
public abstract class FiguraBase implements FiguraGeometrica {
    private String color;
    
    public abstract double calculaPerimetre();
    public abstract double calculaNCostats();
    
    public FiguraBase(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "color: " + this.color;
    }
    
}
