package ACT8_0C;

/**
 *
 * @author winadmin
 */
public class Vehicle {
    private String marca;
    private String model;

    public Vehicle(String marca, String model) {
        this.marca = marca;
        this.model = model;
    }
    
    void arranca() {
        System.out.println("El vehicle " + getMarca() +" arranca.");
    }

    void frena() {
        System.out.println("El vehicle " + getMarca() + " frena.");
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    
}
