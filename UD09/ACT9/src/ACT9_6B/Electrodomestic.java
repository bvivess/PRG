package ACT9_6B;

/**
 *
 * @author winadmin
 */
public abstract class Electrodomestic extends Producte {
    private char classeEnergetica;

    public Electrodomestic(char classeEnergetica, String nom, double preu, double consumEnergetic, int garantiaMesos) {
        super(nom, preu, consumEnergetic, garantiaMesos);
        this.classeEnergetica = classeEnergetica;
    }
    
    // Mètode concret, no cal implementar a les subclasses
    public double calculaSuplement() {
        return ((this.classeEnergetica == 'A') ? 0.05 * super.getPreu() : 
                    (this.classeEnergetica == 'B') ? 0.10 * super.getPreu(): 0.15 * super.getPreu()
               );
    }  
}
