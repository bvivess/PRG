package ACT9_6B;

/**
 *
 * @author winadmin
 */
public final class Rentadora extends Electrodomestic {
    int capacitatCarrega;
    
    public Rentadora(char classeEnergetica, String nom, double preu, double consumEnergetic, int garantiaMesos, int capacitatCarrega) {
        super(classeEnergetica, nom, preu, consumEnergetic, garantiaMesos);
        this.capacitatCarrega = capacitatCarrega;
    }

    //@Override
    //public double calculaSuplement() {
    //    return 0;
    //}
}