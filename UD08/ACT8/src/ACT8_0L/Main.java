package ACT8_0L;

/**
 *
 * @author winadmin
 */

// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Circulo
        FiguraGeometrica figura = new Cercle("Vermell",5.0);
        //FiguraGeometrica figura = new Quadrat("Rosa",5.0);
        
        if (figura instanceof Cercle)
            System.out.print("�rea del cercle: "); 
        else if (figura instanceof Quadrat)
            System.out.print("�rea del quadrat: "); 
        
        System.out.println(figura.calculaArea());
        
    }
}
