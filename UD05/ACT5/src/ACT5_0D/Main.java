package ACT5_0D;

/**
 *
 * @author T.Vives
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleat e1 = new Empleat(); e1.nom = "Joan Martínez"; e1.souVariable = 1000;
        Empleat e2 = new Empleat(); e2.nom = "Pere Martell"; e2.souVariable = 500; 
        Empleat.modificaSouBase(2000);  // també 'Empleat.souBase = 2000;'
        e1.mostraPersona();
        e2.mostraPersona();
    }
}
