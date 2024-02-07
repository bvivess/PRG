package ACT8_0G;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la clase concreta (Automovil)
        Cotxe cotxe = new Cotxe(2, "Turisme");

        // Llamar al método concreto heredado de la clase abstracta
        cotxe.mostraInformacionGeneral();

        // Llamar al método concreto implementado en la clase concreta
        cotxe.mostraDetalles();
    }
}