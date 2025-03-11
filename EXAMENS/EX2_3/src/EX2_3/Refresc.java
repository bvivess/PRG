package EX2_3;

// Subclasses de Beguda
public class Refresc extends Beguda {
    public Refresc(String nom) { 
        super(nom);
    }
    
    @Override
    public boolean esBegudaAlcoholica() {
        return false;
    }
}


