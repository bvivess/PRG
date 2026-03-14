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
        return "Modul " + "ID=" + this.idModul + ", nom=" + this.nom + ", Hores setmanals=" + this.horesSetmanals;
    }
}
