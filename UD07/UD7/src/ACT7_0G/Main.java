package ACT7_0G;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la clase concreta (Automovil)
        Cotxe cotxe = new Cotxe(2, "Turisme");

        // Llamar al m�todo concreto heredado de la clase abstracta
        cotxe.mostraInformacionGeneral();

        // Llamar al m�todo concreto implementado en la clase concreta
        cotxe.mostraDetalles();
    }
}