package ACT5_0D;

/**
 *
 * @author T.Vives
 */
public class Empleat {
    public String nom;
    public static double souBase;
    public double souVariable;

    // M�tode est�tic 
    public static void modificaSouBase(double nouSouBase) {
        souBase = nouSouBase;
    }
    // M�tode no est�tic
    public double calcularSou() {
        return souBase + souVariable;
    }
}
