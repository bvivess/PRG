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
        // Crear objectes de les classes derivades
        Cotxe cotxe = new Cotxe("Opel", "Corsa");
        Moto moto = new Moto("Yamaha", "SRX");

        cotxe.arranca();  // Mètode de la Superclasse
        cotxe.condueix();  // Mètode de la Subclasse
        cotxe.frena();  // Mètode de la Subclasse

        System.out.println();

        moto.arranca();  // Mètode de la clase Superclasse
        moto.acelera();  // Mètode de la Subclasse
        moto.frena();  // Mètode de la Subclasse
    }
}

