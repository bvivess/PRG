package EX2_3;

public class Espirituosa extends Beguda {
    private float graduacio;
    
    public Espirituosa(String nom, float graduacio) {
        super(nom);
        this.graduacio = graduacio;
    }
    
    @Override
    public double calculaPreu() {
        return UtilBeure.PREU_BEGUDA * (this.esBegudaAlcoholica() ? 2 : 1);
    }

    @Override
    public boolean esBegudaAlcoholica() {
        return this.graduacio >= 5;
    }
}
