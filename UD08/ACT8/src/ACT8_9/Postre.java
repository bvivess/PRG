package ACT8_9;

// Classe Postre que hereta de Plat
class Postre extends Plat {
    private boolean teSuplementXocolata;

    public Postre(String nom, double preuBase, boolean teSuplementXocolata) {
        super(nom, preuBase);
        this.teSuplementXocolata = teSuplementXocolata;
    }
    
    @Override
    public double calculaSuplement() {
        return teSuplementXocolata ? 1.0 : 0;
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Postre)";
    }
}
