package Prova;


/**
 *
 * @author winadmin
 */
public class Empleat {
    public String nom;
    public static double souBase = 1000;

    public Empleat(String nom) {
        this.nom = nom;
    }

    // M�tode est�tic 
    public static void modificarSouBase(double nouSouBase) {
        souBase = nouSouBase;
    }

}
