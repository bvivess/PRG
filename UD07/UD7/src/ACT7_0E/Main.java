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

        // Execuci�
        System.out.println(cercle.toString());  // M�tode de la classe abstracta
        //miCirculo.mostrarRadio();  // M�todo de la clase derivada
        System.out.println("�rea del cercle: " + cercle.calculaArea()); // M�tode abstracte implementat en la subclasse 
    }
}
