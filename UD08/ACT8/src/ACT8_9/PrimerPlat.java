package ACT8_9;

// Classe PrimerPlat que hereta de Plat
class PrimerPlat extends Plat {
    private boolean esVegetarià;
    
    public PrimerPlat(String nom, double preuBase, boolean esVegetarià) {
        super(nom, preuBase);
        this.esVegetarià = esVegetarià;
    }
    
    @Override
    public double calculaSuplement() {
        return esVegetarià ? 0 : 1.5; // Suplement si no és vegetarià
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Primer plat)";
    }
}
