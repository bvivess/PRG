package ACT9_3;

/**
 *
 * @author winadmin
 */
public class Camio extends Vehicle {
    private double capacitatCarrega;

    public Camio(String marca, String model, double preu, double capacitatCarrega) {
        super(marca, model, preu);
        this.capacitatCarrega = capacitatCarrega;
    }

    @Override
    public double calculaImpost() {
        return super.getPreu()*0.15;
    }  
    
}
