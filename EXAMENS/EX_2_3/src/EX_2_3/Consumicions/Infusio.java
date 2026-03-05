package EX_2_3.Consumicions;

public class Infusio extends Beguda {
    private boolean esEstimulant;

    public Infusio( String nom, double preu, boolean esEstimulant) {
        super(nom, preu);
        this.esEstimulant = esEstimulant;
    }
    
    @Override
    public boolean esEstimulant() {
        return this.esEstimulant;
    }

    @Override
    public String toString() {
        return super.toString() + " esEstimulant=" + esEstimulant + '}';
    }
}
