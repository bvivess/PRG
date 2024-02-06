package PRG_EX_UD8;

/** Figura geomètrica de 3 costats
 *
 * @author winadmin
 */
public class Triangle extends FiguraGeometrica {
    // mida de cada costat
    protected double costat1;  // 'cateto1' o 'altura' en cas de 'TriangleRectangle'
    protected double costat2;  // 'cateto2' o 'base' en cas de 'TriangleRectangle'
    protected double costat3;  // 'hipotenusa' en cas de 'TriangleRectangle'

    public Triangle(String color, double costat1, double costat2, double costat3, Posicio posicio) {
        super(color, posicio);
        this.costat1 = costat1;
        this.costat2 = costat2;
        this.costat3 = costat3;
    }
    
    public double calculaArea() {
        double s = (costat1 + costat2 + costat3) / 2;
        return Math.sqrt(s * (s - costat1) * (s - costat2) * (s - costat3));
    }
    
    public double calculaPerimetre() {
        return costat1 + costat2 + costat3;
    }
    
    public int calculaNCostats() {
        return 3;
    }
    
    @Override
    public String toString() {
        return super.toString() + " Triangle: " + this.costat1 + "-" + this.costat2 + "-" + this.costat3;
    }
    
    @Override
    public boolean equals(Object o) {
        Triangle t = (Triangle) o; 
        if ( (super.equals(o)) &&
             (t.costat1 == this.costat1) &&
             (t.costat2 == this.costat2) &&
             (t.costat3 == this.costat3) ) {
            System.out.println("Costats iguals");
            return true;
        } else {
            System.out.println("Costats diferents");
            return false;
        }
    }

}
