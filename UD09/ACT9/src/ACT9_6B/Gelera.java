package ACT9_6B;

/**
 *
 * @author winadmin
 */
public class Gelera extends Electrodomestic {

    public Gelera(char classeEnergetica, String nom, double preu, double consumEnergetic, int garantiaMesos) {
        super(classeEnergetica, nom, preu, consumEnergetic, garantiaMesos);
    }
    
    @Override
    public String toString() {
        return "Gelera {" + super.toString() + "} Preu: " + super.getPreu() + " " + this.calculaSuplement();
    }
    
    //@Override
    //public double calculaSuplement() {
    //    return 0;
    //}
}
