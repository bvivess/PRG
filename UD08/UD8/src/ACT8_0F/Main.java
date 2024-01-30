package ACT8_0F;

/**
 *
 * @author winadmin
 */

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Television
        int[] initialConfiguration = {50, 70, 80}; // Brillo, Color, Contraste
        Television televisio = new Television("Sony", false, "Model Trinitron", 42, 1, false, initialConfiguration);

        // Mostrar información inicial
        System.out.println("Initial TV Info:");
        System.out.println(televisio);

        // Encender el televisor
        televisio.turnOn();

        // Cambiar de canal
        televisio.changeChannel(5);

        // Mostrar información después de cambiar de canal
        System.out.println("\nTV Info After Changing Channel:");
        System.out.println(televisio.toString());

        // Inicializar la pantalla con una nueva configuración
        int[] newConfiguration = {60, 80, 90}; // Nueva configuración de brillo, color, contraste
        televisio.initializeScreen(newConfiguration);

        // Mostrar información después de inicializar la pantalla
        System.out.println("\nTV Info After Initializing Screen:");
        System.out.println(televisio);

        // Apagar el televisor
        televisio.turnOff();

        // Mostrar información después de apagar
        System.out.println("\nTV Info After Turning Off:");
        System.out.println(televisio);
    }
}