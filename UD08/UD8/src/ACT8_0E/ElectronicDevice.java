package ACT8_0E;

/**
 *
 * @author winadmin
 */

public abstract class ElectronicDevice {
    String a;
    
    public abstract void turnOn();
    public abstract void turnOff();
    
    @Override
    public String toString() {
        return a;
    }
}