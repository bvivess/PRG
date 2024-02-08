package ACT9_3;

/**
 *
 * @author winadmin
 */
// Clase abstracta para Vehículos
public abstract class Vehicle {
    private String marca;
    private String model;
    private double preu;

    public Vehicle(String marca, String model, double preu) {
        this.marca = marca;
        this.model = model;
        this.preu = preu;
    }
    
    public abstract double calculaImpost();

    // Getters y setters
    public double getPreu() {
        return preu;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "marca: " + marca + ", model: " + model + ", preu: " + preu + '}';
    }

    

}
