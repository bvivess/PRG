package ACT7_0C;

/**
 *
 * @author T.Vives
 */
// Clase derivada 1
class Cotxe extends Vehicle {

    public Cotxe(String marca, String model) {
        super(marca, model);
    }
    
    void condueix() {
        System.out.println("El cotxe " + getMarca() + " està en moviment.");
    }
    
}
