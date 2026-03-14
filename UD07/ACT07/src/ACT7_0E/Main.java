/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package ACT7_0E;

/**
 *
 * @author winadmin
 */
// Classe principal
public class Main {
    public static void main(String[] args) {
        // Crear un objete de la classe 'Cercle'
        Cercle cercle = new Cercle("Vermell",5.0);
        Quadrat quadrat = new Quadrat("Rosa",5.0);
        
        cercle.hasColor("Verd");
        quadrat.hasColor("Blanc");

        // Execució
        System.out.println(cercle.toString());  // Mètode de la classe abstracta
        //miCirculo.mostrarRadio();  // Método de la clase derivada
        System.out.println("Àrea del cercle: " + cercle.calculaArea()); // Mètode abstracte implementat en la subclasse 
    }
}
