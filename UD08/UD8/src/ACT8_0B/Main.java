package ACT8_0B;

/**
 *
 * @author T.Vives
 */
// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Gato
        Ca ca = new Ca();

        // Llamar a métodos de las clases base y derivadas
        ca.menja();  // Mètode de la clase base
        ca.alimenta();  // Mètode de la clase derivada 1
        ca.lladra();  // Método de la clase derivada 2
    }
}
