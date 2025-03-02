package ACT8_9;

// Classe SegonPlat que hereta de Plat i implementa Descompte
class SegonPlat extends Plat implements Descompte {
    private boolean inclouGuarnició;
    
    public SegonPlat(String nom, double preuBase, boolean inclouGuarnició) {
        super(nom, preuBase);
        this.inclouGuarnició = inclouGuarnició;
    }
    
    @Override
    public double calculaSuplement() {
        return inclouGuarnició ? 2.0 : 0;
    }
    
    @Override
    public double aplicaDescompte() {
        return getPreuBase() > 15 ? 2.0 : 0; // Descompte per plats cars
    }

    @Override
    public double calculaPreuFinal() {
        return super.calculaPreuFinal() - this.aplicaDescompte();
    }

    @Override
    public String toString() {
        return super.toString() + " (Segon plat)";
    }
}
