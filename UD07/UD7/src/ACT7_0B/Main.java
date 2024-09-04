package ACT7_0B;

/**
 *
 * @author T.Vives
 * 
 * Exemple de Her�ncia Multinivell:
 *     Animal
 *        ^ 
 *        |
 *     Mamifer
 *        ^ 
 *        |
 *       Ca
 * 
 */
// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Gato
        Ca ca = new Ca("Animal", "Mamifer", "Ca");

        // Llamar a m�todos de las clases base y derivadas
        ca.menja();  // M�tode de la clase base
        ca.alimenta();  // M�tode de la clase derivada 1
        ca.lladra();  // M�todo de la clase derivada 2
    }
}
