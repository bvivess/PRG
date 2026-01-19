package ACT6_1A;

/**
 *
 * @author T.Vives
 */

public class Modul {
    private int idModul;
    private String nom;
    private int idCicle;
    private int horesSetmanals;
 
    // Constructor
    public Modul(int idModul, String nom, int idCicle, int horesSetmanals) {    
        this.idModul = idModul;
        this.nom = nom;
        this.idCicle = idCicle;
        this.horesSetmanals = horesSetmanals;
    }

    // Mòduls
    public String mostraModul() {
        return "Modul " + "ID=" + this.idModul + ", nom=" + this.nom + ", Hores setmanals=" + this.horesSetmanals;
    }
    
}
