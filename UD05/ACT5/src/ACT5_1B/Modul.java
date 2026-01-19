package ACT5_1B;

/**
 *
 * @author T.Vives
 */
public class Modul {
    public int idModul;
    public String nom;
    public int horesSetmanals;
    //
    public static int comptadorModuls=1;
    
    // Mòduls
    public String mostraModul() {
        return "Modul " + "ID=" + idModul + ", nom=" + nom + ", Hores setmanals=" + horesSetmanals;
    }
}
