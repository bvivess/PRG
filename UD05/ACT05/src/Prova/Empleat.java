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

    // Mètode estàtic 
    public static void modificarSouBase(double nouSouBase) {
        souBase = nouSouBase;
    }

}
