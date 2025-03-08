package ACT8_9;

// Classe abstracta Plat
abstract class Plat {
    private String nom;
    private double preuBase;
    
    public Plat(String nom, double preuBase) {
        this.nom = nom;
        this.preuBase = preuBase;
    }
    
    public abstract double calculaSuplement();

    public double calculaPreuFinal() {
        return this.preuBase + this.calculaSuplement();
    }

    public String getNom() {
        return nom;
    }

    public double getPreuBase() {
        return preuBase;
    }

    @Override
    public String toString() {
        return nom + " - Preu base: " + preuBase + "¤";
    }
}
