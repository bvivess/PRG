package ACT8_0F;

/**
 *
 * @author winadmin
 */

public class Television extends ElectronicDevice {
    String b;
    
    public void turnOn() {
        changeChannel(1);
        initializeScreen();
    }

    public void turnOff() {}
    public void changeChannel(int channel) {}
    public void initializeScreen() {}
    
    @Override
    public String toString() {
        return b;
    }
}