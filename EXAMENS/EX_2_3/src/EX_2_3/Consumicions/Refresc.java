package EX_2_3.Consumicions;


public class Refresc extends Beguda {

    public Refresc(String nom, double preu) {
        super(nom, preu);
    }
    
    @Override
    public boolean esEstimulant() {
        return false;
    }

}
