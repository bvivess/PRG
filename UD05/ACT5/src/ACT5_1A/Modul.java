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
    public String mostraModul(int p_idCicle) {
        String text = "";
        
        if (idCicle == p_idCicle)
            text = "Modul " + "ID=" + idModul + ", nom=" + nom + ", Hores setmanals=" + horesSetmanals;
        
        return text;
    }
}
