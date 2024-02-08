package ACT9_3;

/**
 *
 * @author winadmin
 */
// Clase para Motocicletas
public class Motocicleta extends Vehicle {
    private int cilindrada;
    private String tipus;

    public Motocicleta(String marca, String modelo, double preu, int cilindrada, String tipus) {
        super(marca, modelo, preu);
        this.cilindrada = cilindrada;
        this.tipus = tipus;
    }

    @Override
    public double calculaImpost() {
        return 0.05 * getPreu(); // Impuesto del 5%
    }
}
