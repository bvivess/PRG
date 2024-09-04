package ACT7_0C;

/**
 *
 * @author T.Vives
 * 
 * Exemple de Her�ncia Jer�rquica
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

        cotxe.arranca();  // M�tode de la Superclasse
        cotxe.condueix();  // M�tode de la Subclasse
        cotxe.frena();  // M�tode de la Subclasse

        System.out.println();

        moto.arranca();  // M�tode de la clase Superclasse
        moto.acelera();  // M�tode de la Subclasse
        moto.frena();  // M�tode de la Subclasse
    }
}

