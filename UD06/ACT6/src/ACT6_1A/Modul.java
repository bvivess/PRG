package ACT6_1A;

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
    public String mostraModul(int idCicle) {
        String text = "";
        
        if (this.idCicle == idCicle)
            text = "Modul " + "ID=" + this.idModul + ", nom=" + this.nom + ", numAlumnes=" + this.horesSetmanals;
        
        return text;
    }
}
