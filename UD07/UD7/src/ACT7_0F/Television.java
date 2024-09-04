package ACT7_0F;

/**
 *
 * @author winadmin
 */

public class Television extends ElectronicDevice {
    private String model;
    private int screenSize;
    private int currentChannel;
    private boolean screenInitialized;
    private int configuration[]; // Brillo, Color, Contrast 

    public Television(String brand, boolean onOff, String model, int screenSize, int currentChannel, boolean screenInitialized, int[] configuration) {
        super(brand, onOff);
        this.model = model;
        this.screenSize = screenSize;
        this.currentChannel = currentChannel;
        this.screenInitialized = screenInitialized;
        this.configuration = configuration;
    }

    public void turnOn() {
        System.out.println("Turning on the television");
        // L�gica para encender el televisor
        super.onOff = true;;
    }

    public void turnOff() {
        System.out.println("Turning off the television");
        // L�gica para apagar el televisor
        super.onOff = false;
    }
    // Implementaci�n del m�todo para cambiar de canal
    public void changeChannel(int channel) {
        System.out.println("Changing channel to " + channel);
        // L�gica para cambiar de canal
        currentChannel = channel;
    }
    public void initializeScreen(int[] configuracion) {
        System.out.println("Initializing the screen");
        // Simulaci�n de la configuraci�n de la pantalla (brillo, contraste, etc.)
        this.screenInitialized = true;
        this.configuration[0] = configuracion[0];
        this.configuration[1] = configuracion[1];
        this.configuration[2] = configuracion[2];
    }
    
    @Override
    public String toString() {
        return super.toString() + " Model: " + this.model + " Canal: " + this.currentChannel + 
                                  " Configuraci�: " + configuration[0] + " " + configuration[1] + " " + configuration[2];
    }
}