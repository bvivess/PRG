package ACT5_1A;

/**
 *
 * @author T.Vives
 */

public class Modul {
    public int idModul;
    public String nom;
    public int idCicle;
    public int horesSetmanals;
 
    // Mòduls
    public String mostraModul() {
        return "Modul " + "ID=" + idModul + ", nom=" + nom + ", Hores setmanals=" + horesSetmanals;
    }
}
