package ACT8_9;

// Classe PrimerPlat que hereta de Plat
class PrimerPlat extends Plat {
    private boolean esVegetari�;
    
    public PrimerPlat(String nom, double preuBase, boolean esVegetari�) {
        super(nom, preuBase);
        this.esVegetari� = esVegetari�;
    }
    
    @Override
    public double calculaSuplement() {
        return esVegetari� ? 0 : 1.5; // Suplement si no �s vegetari�
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Primer plat)";
    }
}
