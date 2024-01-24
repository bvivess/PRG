/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package ACT8_0E;

/**
 *
 * @author winadmin
 */
// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Circulo
        Cercle cercle = new Cercle("Vermell",5.0);

        // Llamar a métodos de la clase abstracta y clase derivada
        System.out.println(cercle.toString());  // Método de la clase abstracta
        //miCirculo.mostrarRadio();  // Método de la clase derivada
        System.out.println("Área del círculo: " + cercle.calculaArea()); // Método abstracto implementado en la clase derivada
    }
}
