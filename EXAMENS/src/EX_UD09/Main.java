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
        figuresBase.add(new TriangleEquilater("Blau", 5));
        figuresBase.add(new Quadrat("Vermell",5));
        figuresBase.add(new Rectangle("Verd", 5, 10));
        
        // Figura composta: triangle, quadrat, rectangle
        FiguraComposta figuraComposta = new FiguraComposta(figuresBase);

        // Mostrar resultats
        System.out.println(figuraComposta.toString() + ", Àrea: " + figuraComposta.calculaArea());
    }
    
}
