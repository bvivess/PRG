package ACT9_3;

/**
 *
 * @author winadmin
 */
public class Automobil extends Vehicle {
    private int numPortes;
    private double capacitatMaleter;

    public Automobil(String marca, String model, double preu, int numPortes, double capacitatMaleter) {
        super(marca, model, preu);
        this.numPortes = numPortes;
        this.capacitatMaleter = capacitatMaleter;
    }

    @Override
    public double calculaImpost() {
        return 0.1 * getPreu(); // Impost del 10%
    }
}