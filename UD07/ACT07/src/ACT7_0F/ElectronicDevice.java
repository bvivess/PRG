package ACT7_0F;

/**
 *
 * @author winadmin
 */

public abstract class ElectronicDevice {
    protected String marca;
    protected boolean onOff;
    
    public abstract void turnOn();
    public abstract void turnOff();

    public ElectronicDevice(String marca, boolean onOff) {
        this.marca = marca;
        this.onOff = onOff;
    }
    
    @Override
    public String toString() {
        return "Marca: " + this.marca + " On/Off: " + this.onOff;
    }
}