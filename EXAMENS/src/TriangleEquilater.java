

import EX_UD08.*;

/** Triangle amb 3 costats iguals
 *
 * @author winadmin
 */
public class TriangleEquilater extends Triangle {

    public TriangleEquilater(String color, double costat1, double costat2, double costat3, Posicio posicio) {
        super(color, costat1, costat2, costat3, posicio);
        if ((costat1 != costat2) || (costat2 != costat3) || (costat1 != costat3))
            throw new IllegalArgumentException("Costats diferents");
    }

    public double calculaAltura() {
        return Math.sqrt(3) / 2 * super.costat1;
    }
    
}
