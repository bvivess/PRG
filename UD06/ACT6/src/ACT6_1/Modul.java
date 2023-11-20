package ACT6_1;

/**
 *
 * @author T.Vives
 */
public class Modul {
    private  int idModul;
    private String nom;
    private int idCicle;
    private int horesSetmanals;
    //
    private static int comptadorModuls=1;

    // Constructor
    public Modul(String nom, int idCicle, int horesSetmanals) {    
        this.idModul = getComptadorModuls();
        this.nom = nom;
        this.idCicle = idCicle;
        this.horesSetmanals = horesSetmanals;
    }

    // Getters
    public int getIdModul() {
        return idModul;
    }

    public String getNom() {
        return nom;
    }

    public int getIdCicle() {
        return idCicle;
    }

    public int getHoresSetmanals() {
        return horesSetmanals;
    }

    public static int getComptadorModuls() {
        return comptadorModuls++;
    }

    // Setters
    public void setIdModul(int idModul) {
        this.idModul = idModul;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIdCicle(int idCicle) {
        this.idCicle = idCicle;
    }

    public void setHoresSetmanals(int horesSetmanals) {
        this.horesSetmanals = horesSetmanals;
    }
    
}
