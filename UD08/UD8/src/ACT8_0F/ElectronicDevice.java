package ACT8_0F;

/**
 *
 * @author winadmin
 */

public abstract class ElectronicDevice {
    protected String brand;
    protected boolean onOff;
    
    public abstract void turnOn();
    public abstract void turnOff();

    public ElectronicDevice(String brand, boolean onOff) {
        this.brand = brand;
        this.onOff = onOff;
    }
    
    @Override
    public String toString() {
        return "Marca: " + this.brand + " On/Off: " + this.onOff;
    }
}