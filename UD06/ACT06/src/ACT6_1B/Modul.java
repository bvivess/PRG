package ACT6_1B;

/**
 *
 * @author T.Vives
 */
public class Modul {
    private int idModul;
    private String nom;
    private int horesSetmanals;
    //
    public static int comptadorModuls=1;

    public Modul(int idModul, String nom, int horesSetmanals) {
        this.idModul = idModul;
        this.nom = nom;
        this.horesSetmanals = horesSetmanals;
    }
    
    // Mòduls
    public String mostraModul() {
        return "Modul " + "ID=" + this.idModul + ", nom=" + this.nom + ", Hores setmanals=" + this.horesSetmanals;
    }

    public int getIdModul() {
        return idModul;
    }

    public void setIdModul(int idModul) {
        this.idModul = idModul;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHoresSetmanals() {
        return horesSetmanals;
    }

    public void setHoresSetmanals(int horesSetmanals) {
        this.horesSetmanals = horesSetmanals;
    }

    public static int getComptadorModuls() {
        return Modul.comptadorModuls;
    }

    public static void setComptadorModuls(int comptadorModuls) {
        Modul.comptadorModuls = comptadorModuls;
    }
    
    
}
