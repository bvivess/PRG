package EX_UD09;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {        
        // Figures Base
        ArrayList<FiguraBase> figuresBase = new ArrayList<>();
        figuresBase.add(new TriangleEquilater(5, "blau"));
        figuresBase.add(new Quadrat(5,"vermell"));
        figuresBase.add(new Rectangle(5, 10, "verd"));
        
        // Figura composta: triangle, quadrat, rectangle
        FiguraComposta figuraComposta = new FiguraComposta(figuresBase);

        // Mostrar resultats
        System.out.println(figuraComposta.toString() + ", Àrea: " + figuraComposta.calculaArea());
    }
    
}
