package ACT8_6B;

/**
 *
 * @author winadmin
 */
public abstract class Producte {
    private String nom;
    private double preuBase;
    private double consumEnergetic;
    private int garantiaMesos;

    public Producte(String nom, double preuBase, double consumEnergetic, int garantiaMesos) {
        this.nom = nom;
        this.preuBase = preuBase;
        this.consumEnergetic = consumEnergetic;
        this.garantiaMesos = garantiaMesos;
    }
    
    public abstract double calculaDescompte();
    public abstract double calculaSuplement();
    
    public double calculaPreu() {
        return this.getPreuBase() + this.calculaSuplement() - this.calculaDescompte();
    };
    
    // Getters i setters
    public String getNom() {
        return nom;
    }

    public double getPreuBase() {
        return preuBase;
    }

    public double getConsumEnergetic() {
        return consumEnergetic;
    }

    public int getGarantiaMesos() {
        return garantiaMesos;
    }

    @Override
    public String toString() {
        return "Producte {" +
                "Nom: " + this.nom + 
                ", Preu: " + this.preuBase +
                ", ConsumEnergetic: " + this.consumEnergetic +
                ", GarantiaMesos: " + this.garantiaMesos +
                "} Preu Producte= " + this.calculaPreu();
    }
}