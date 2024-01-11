package ACT8_0B;

/**
 *
 * @author T.Vives
 */
// Clase derivada 1
public class Mamifer extends Animal {
    private String tipusMamifer;

    public Mamifer(String tipusMamifer, String tipusAnimal) {
        super(tipusAnimal);
        this.tipusMamifer = tipusMamifer;
    }
    
    void alimenta() {
        System.out.println("Un mamífer amamanta les cries ...");
    }
}
