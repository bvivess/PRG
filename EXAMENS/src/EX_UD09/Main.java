package EX_UD09;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        // Figures base
        TriangleEquilater triangle = new TriangleEquilater(5, "blau");
        Quadrat quadrat = new Quadrat(5,"vermell");
        Rectangle rectangle = new Rectangle(5, 10, "verd");
        
        // Figura composta: triangle, quadrat, rectangle
        ArrayList<FiguraBase> figuresBase = new ArrayList<>();
        FiguraComposta figuraComposta = new FiguraComposta(figuresBase);
        figuresBase.add(triangle);
        figuresBase.add(quadrat);
        figuresBase.add(rectangle);

        // Mostrar resultats
        System.out.println(figuraComposta.toString() + ", Àrea: " + figuraComposta.calculaArea());
    }
    
}
