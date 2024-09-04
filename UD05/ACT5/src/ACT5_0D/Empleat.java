package ACT5_0D;

/**
 *
 * @author T.Vives
 */
public class Empleat {
    public String nom;
    public static double souBase;
    public double souVariable;

    // Mètode estàtic 
    public static void modificaSouBase(double nouSouBase) {
        souBase = nouSouBase;
    }
    // Mètode no estàtic
    public double calcularSou() {
        return souBase + souVariable;
    }
}
