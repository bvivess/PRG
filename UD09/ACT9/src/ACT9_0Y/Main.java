package ACT9_0Y;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */

// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Circulo
        ArrayList<FiguraGeometrica> figures = new ArrayList<FiguraGeometrica>();
        FiguraGeometrica figuraGeometrica = new Cercle("Vermell",5.0);
        figures.add(figuraGeometrica);
        figuraGeometrica = new Quadrat("Groc",5.0);
        figures.add(figuraGeometrica);
        figuraGeometrica = new Rectangle("Blau",5.0, 2.0);
        figures.add(figuraGeometrica);
        
        for (FiguraGeometrica f : figures) {
            System.out.println(f.toString() + " " + f.calculaArea());
        }
        
    }
}
