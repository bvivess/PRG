package EX_2_3.Consumicions;

public class Alcohol extends Beguda {
    private int graduacio;

    public Alcohol(String nom, double preu, int graduacio) {
        super(nom, preu);
        this.graduacio = graduacio;
    }
    
    @Override
    public boolean esEstimulant() {
        return (this.graduacio>=5);
    }

    @Override
    public String toString() {
        return super.toString() + " graduacio=" + graduacio + '}';
    }
    
}
