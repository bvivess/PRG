package ACT8_9;

// Classe SegonPlat que hereta de Plat i implementa Descompte
class SegonPlat extends Plat implements Descompte {
    private boolean inclouGuarnici�;
    
    public SegonPlat(String nom, double preuBase, boolean inclouGuarnici�) {
        super(nom, preuBase);
        this.inclouGuarnici� = inclouGuarnici�;
    }
    
    @Override
    public double calculaSuplement() {
        return inclouGuarnici� ? 2.0 : 0;
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
