package ACT7_0B;

/**
 *
 * @author T.Vives
 */
// Clase derivada 1
public class Mamifer extends Animal {
    private String tipusMamifer;

    public Mamifer(String tipusAnimal, String tipusMamifer) {
        super(tipusAnimal);  // COnstructor de la Superclasse
        this.tipusMamifer = tipusMamifer;
    }
    
    void alimenta() {
        System.out.println("Un mam�fer amamanta les cries ...");
    }
}
