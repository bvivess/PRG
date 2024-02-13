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
    private String tipus;

    public Vehicle(String marca, String model, double preu, String Tipus) {
        this.marca = marca;
        this.model = model;
        this.preu = preu;
        this.tipus = tipus;
    }
    
    public abstract double calculaImpost();

    // Getters y setters
    public double getPreu() {
        return preu;
    }

    @Override
    public String toString() {
        return "Vehicle {" + "marca: " + this.marca + ", model: " + this.model + ", tipus: " + this.tipus + ", preu: " + this.preu + '}';
    }

    

}
