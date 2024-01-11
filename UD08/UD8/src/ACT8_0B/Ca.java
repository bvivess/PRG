package ACT8_0B;

/**
 *
 * @author winadmin
 */
public class Ca extends Mamifer {
    private String tipusCar;

    public Ca(String tipusCar, String tipusMamifer, String tipusAnimal) {
        super(tipusMamifer, tipusAnimal);
        this.tipusCar = tipusCar;
    }
    
    void lladra() {
        System.out.println("El ca lladra ...");
    }
}