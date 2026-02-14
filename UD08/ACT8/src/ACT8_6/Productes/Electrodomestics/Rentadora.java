package ACT8_6.Productes.Electrodomestics;

public final class Rentadora extends Electrodomestic {
    int capacitatCarrega;
    
    public Rentadora(String nom, double preu, double consumEnergetic, int garantiaMesos, int capacitatCarrega, char classeEnergetica) {
        super(nom, preu, consumEnergetic, garantiaMesos, classeEnergetica);
        this.capacitatCarrega = capacitatCarrega;
    }

    //@Override
    //public double calculaSuplement() {
    //    return 0;
    //}
}