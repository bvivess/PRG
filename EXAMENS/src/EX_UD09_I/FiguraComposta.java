package EX_UD09_I;

import java.util.ArrayList;

/** Quadrat amb 1 dels angles de 90 graus 
 *
 * @author winadmin
 */
public class FiguraComposta implements FiguraGeometrica {
    ArrayList<FiguraBase> figuresBase;

    public FiguraComposta(ArrayList<FiguraBase> figuresBase) {
        this.figuresBase = figuresBase;
    }
    
    @Override
    public double calculaArea() {
        double area = 0;
        
        for (FiguraBase f : figuresBase) 
            area += f.calculaArea();
        return area;
    }

    @Override
    public String toString() {
        String text = "";
        for (FiguraBase f : figuresBase) 
            text += "\n\t" + f.toString();
        return "FiguraComposta {" + text + "\n}";
    }
    
}
