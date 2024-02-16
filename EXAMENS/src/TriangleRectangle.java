

import EX_UD08.*;

/** Triangle amb 1 dels angles de 90 graus 
 *
 * @author winadmin
 */
public class TriangleRectangle extends Triangle {

    public TriangleRectangle(String color, double costat1, double costat2, double costat3, Posicio posicio) {
        super(color, costat1, costat2, costat3, posicio);
    }
    
    public double calculaAltura() {
        return super.costat1;
    }

}
