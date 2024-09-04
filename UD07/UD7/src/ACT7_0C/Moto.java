package ACT7_0C;

/**
 *
 * @author T.Vives
 */
// Clase derivada 2
class Moto extends Vehicle {

    public Moto(String marca, String model) {
        super(marca, model);
    }
    
    void acelera() {
        System.out.println("La moto " + getMarca() + " accelera.");
    }
}
