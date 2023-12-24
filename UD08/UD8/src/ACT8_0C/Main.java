package ACT8_0C;

/**
 *
 * @author T.Vives
 * 
 * Exemple de Herència Jeràrquica
 *     Vehicle
 *     ^    ^
 *     |    |
 * Cotxe    Moto
 * 
 */
// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear objetos de las clases derivadas
        Cotxe cotxe = new Cotxe();
        Moto moto = new Moto();

        // Llamar a métodos de la clase base y clases derivadas
        cotxe.arranca();  // Mètode de la clase base
        cotxe.condueix();  // Mètode de la clase derivada 1
        cotxe.frena();  // Mètode de la clase base

        System.out.println();

        moto.arranca();  // Mètode de la clase base
        moto.acelera();  // Mètode de la clase derivada 2
        moto.frena();  // Mètode de la clase base
    }
}

