package EX_2_3.Consumicions;

public abstract class Beguda extends Consumicio implements ConsumicioBase {

    public Beguda(String nom, double preu) {
        super(nom, preu);
    }
    
    public Beguda(String nom) {
        super(nom);
    }
    
    public abstract boolean esEstimulant();
    
    @Override
    public double calculaPreu() {
        double preuBase = super.getPreu();
        return preuBase + (preuBase * (this.esEstimulant() ? ConsumicioBase.IVA_ESTIMULANT : ConsumicioBase.IVA_BASE));
    }
    
    @Override
    public String toString() {
        return super.toString() + " Preu IVA= " + this.calculaPreu();
    }

}

