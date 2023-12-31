/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package ACT9_0A;

/**
 *
 * @author winadmin
 */
// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Circulo
        Cercle cercle = new Cercle(5.0);

        // Llamar a métodos de la clase abstracta y clase derivada
        // System.out.println(cercle.toString());  // Método de la clase abstracta
        //miCirculo.mostrarRadio();  // Método de la clase derivada
        System.out.println("Área del círculo: " + cercle.calcularArea()); // Método abstracto implementado en la clase derivada
    }
}
