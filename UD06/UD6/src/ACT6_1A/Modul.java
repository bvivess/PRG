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
        this.setIdModul(idModul);
        this.setNom(nom);
        this.setIdCicle(idCicle);
        this.setHoresSetmanals(horesSetmanals);
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

    public int getIdCicle() {
        return idCicle;
    }

    public void setIdCicle(int idCicle) {
        this.idCicle = idCicle;
    }

    public int getHoresSetmanals() {
        return horesSetmanals;
    }

    public void setHoresSetmanals(int horesSetmanals) {
        this.horesSetmanals = horesSetmanals;
    }
    
    
}
