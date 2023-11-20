package ACT6_1;

/**
 *
 * @author T.Vives
 */
public class Modul {
    private  int idModul;
    private String nom;
    private int horesSetmanals;
    //
    private static int comptadorModuls;

    static {
        comptadorModuls = 1;
    }
    
    public Modul(String nom, int horesSetmanals) throws Exception {
        if (nom == null || nom.length() == 0){
            throw new Exception("El nom no pot ser nul");
        }
        
        this.idModul=getComptadorModuls();
        this.nom = nom;
        this.horesSetmanals = horesSetmanals;
        
    }
    /**
     * @return the idModul
     */
    public int getIdModul() {
        return idModul;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the horesSetmanals
     */
    public int getHoresSetmanals() {
        return horesSetmanals;
    }

    /**
     * @return the comptadorModuls
     */
    public static int getComptadorModuls() {
        return comptadorModuls++;
    }

    /**
     * @param idModul the idModul to set
     */
    public void setIdModul(int idModul) {
        this.idModul = idModul;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param horesSetmanals the horesSetmanals to set
     */
    public void setHoresSetmanals(int horesSetmanals) {
        this.horesSetmanals = horesSetmanals;
    }

}
