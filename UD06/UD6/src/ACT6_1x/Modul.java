package ACT6_1B;

/**
 * Representa cada un dels moduls associats a un cicle formatiu
 * @author T.Vives
 */
public class Modul {
    private  int idModul;
    private String nom;
    private int horesSetmanals;
    //
    private static int comptadorModuls=1;

    // Constructors
    public Modul(String nom, int horesSetmanals) {
        if (nom == null || nom.length() == 0){
            System.out.println("El nom no pot ser nul");
        } else { 
            this.idModul = getComptadorModuls();
            this.nom = nom;
            this.horesSetmanals = horesSetmanals;
        }
    }
    
    // Getters i Setters
    public int getIdModul() {
        return this.idModul;
    }

    public String getNom() {
        return this.nom;
    }

    public int getHoresSetmanals() {
        return this.horesSetmanals;
    }

    public static int getComptadorModuls() {
        return comptadorModuls++;
    }

    public void setIdModul(int idModul) {
        this.idModul = idModul;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setHoresSetmanals(int horesSetmanals) {
        this.horesSetmanals = horesSetmanals;
    }

}
