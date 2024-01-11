package ACT8_0B;

/**
 *
 * @author T.Vives
 */
// Clase base
public class Animal {
    private String tipusAnimal;

    public Animal(String tipusAnimal) {
        this.tipusAnimal = tipusAnimal;
    }
    
    void menja() {
        System.out.println("Un animal menja per sobreviure.");
    }
}
