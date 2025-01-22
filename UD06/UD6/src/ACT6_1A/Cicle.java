package ACT6_1A;

/**
 *
 * @author T.Vives
 */
public class Cicle {
    private int idCicle;
    private String nom;
    private int numAlumnes;
    
    // Constructor

    public Cicle(int idCicle, String nom, int numAlumnes) {
        this.idCicle = idCicle;
        this.nom = nom;
        this.numAlumnes = numAlumnes;
    }
    
    // Mòduls
    public String mostraCicle() {
        String text;
        
        text = "Cicle " + "ID=" + idCicle + ", nom=" + nom + ", numAlumnes=" + numAlumnes;
        
        return text;
    }
    
    // Getter
    public int getIdCicle() {
        return idCicle;
    }
    
}
