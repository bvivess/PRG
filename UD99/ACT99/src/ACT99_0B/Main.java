package ACT99_0B;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        // Es crea l'objecte 'figuraGeometrica' per tenir acc�s al m�tode 'CreateFiguraGeometrica' a partir de la classe que el cont�
        FiguraGeometricaFactory figuraGeometrica = new FiguraGeometricaFactory();
        // 'FiguraGeometricaFactory.CreateFiguraGeometrica' �s el m�tode que crea els objectes de 'FiguraGeometrica'
        FiguraGeometrica cercle = figuraGeometrica.CreateFiguraGeometrica("Cercle", 5.0);        
        FiguraGeometrica rectangle = figuraGeometrica.CreateFiguraGeometrica("Rectangle", 5.0, 2.0);
        
        System.out.println(cercle.calculaArea());
        System.out.println(rectangle.calculaArea());
    }
    
}
