package ACT6_2;

/**
 *
 * @author T.Vives
 */
public class Modul {
    private  int idModul;
    private String nom;
    private int horesSetmanals;
    //
    private static int comptadorModuls=1;

    // Constructors
    public Modul(String nom, int horesSetmanals) throws Exception {
        if (nom == null || nom.length() == 0){
            throw new Exception("El nom no pot ser nul");
        }
        
        this.idModul=getComptadorModuls();
        this.nom = nom;
        this.horesSetmanals = horesSetmanals;
        
    }
    
    // Getters i Setters
    public int getIdModul() {
        return idModul;
    }

    public String getNom() {
        return nom;
    }

    public int getHoresSetmanals() {
        return horesSetmanals;
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
