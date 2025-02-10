package ACT7_0F;

/**
 *
 * @author winadmin
 */

public class Television extends ElectronicDevice {
    private String model;
    private int screenSize;
    private int currentChannel;
    private int screenConfiguration[]; // configuration[0]-->Brillo, configuration[1]-->Color, configuration[2]-->Contrast 

    public Television(String marca, boolean onOff, String model, int screenSize, int currentChannel, int[] screenConfiguration) {
        super(marca, onOff);
        this.model = model;
        this.screenSize = screenSize;
        this.currentChannel = currentChannel;
        this.screenConfiguration = screenConfiguration;
    }

    public void turnOn() {
        System.out.println("Turning on the television");
        // Lógica para encender el televisor
        super.onOff = true;;
    }

    public void turnOff() {
        System.out.println("Turning off the television");
        // Lógica para apagar el televisor
        super.onOff = false;
    }
    // Implementación del método para cambiar de canal
    public void changeChannel(int channel) {
        System.out.println("Changing channel to " + channel);
        // Lógica para cambiar de canal
        currentChannel = channel;
    }
    public void initializeScreen(int[] configuracion) {
        System.out.println("Initializing the screen");
        // Simulación de la configuración de la pantalla (brillo, contraste, etc.)
        this.screenConfiguration[0] = configuracion[0];
        this.screenConfiguration[1] = configuracion[1];
        this.screenConfiguration[2] = configuracion[2];
    }
    
    @Override
    public String toString() {
        return super.toString() + " Model: " + this.model + " Canal: " + this.currentChannel + 
                                  " Configuració: " + screenConfiguration[0] + " " + screenConfiguration[1] + " " + screenConfiguration[2];
    }
}