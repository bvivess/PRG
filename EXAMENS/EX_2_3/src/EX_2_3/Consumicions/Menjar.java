package EX_2_3.Consumicions;

public abstract class Menjar extends Consumicio implements ConsumicioBase {

    public Menjar(String nom, double preu) {
        super(nom, preu);
    }
    
    public Menjar(String nom) {
        super(nom);
    }

    @Override
    public double calculaPreu() {
        double preuBase = super.getPreu();
        return preuBase + (preuBase * ConsumicioBase.IVA_BASE);
    }
    
    @Override
    public String toString() {
        return super.toString() + " Preu IVA= " + this.calculaPreu();
    }

}
