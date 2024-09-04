package ACT7_0F;

/**
 *
 * @author winadmin
 */

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Television
        int[] initialConfiguration = {50, 70, 80}; // Brillo, Color, Contrast
        Television televisio = new Television("Sony", false, "Trinitron", 42, 1, false, initialConfiguration);

        // Mostrar informaci� inicial
        System.out.println("Info TV Inicial:");
        System.out.println(televisio.toString());

        // TV ON
        televisio.turnOn();

        // Cambiar de canal
        televisio.changeChannel(5);

        // Mostrar informaci� despr�s de cambiar de canal
        System.out.println("Info TV situaci� 1:");
        System.out.println(televisio.toString());

        // Inicializar la pantalla con una nueva configuraci�n
        int[] newConfiguration = {60, 80, 90}; // Nova configuraci� de Brillo, Color, Contrast
        televisio.initializeScreen(newConfiguration);

        // Mostrar informaci�n despu�s de inicializar la pantalla
        System.out.println("Info TV situaci� 2:");
        System.out.println(televisio.toString());

        // Apagar el televisor
        televisio.turnOff();

        // Mostrar informaci�n despu�s de apagar
        System.out.println("Info TV Final:");
        System.out.println(televisio);
    }
}