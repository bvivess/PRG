package ACT8_0B;

/**
 *
 * @author winadmin
 */
public class Ca extends Mamifer {
    private String tipusCa;

    public Ca(String tipusAnimal, String tipusMamifer, String tipusCa ) {
        super(tipusMamifer, tipusAnimal);  // Constructor de la Superclasse
        this.tipusCa = tipusCa;
    }
    
    void lladra() {
        System.out.println("El ca lladra ...");
    }
}