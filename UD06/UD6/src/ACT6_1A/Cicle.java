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
        return "Cicle " + "ID=" + this.idCicle + ", nom=" + this.nom + ", numAlumnes=" + this.numAlumnes;
    }
    
    // Getters i Setters
    public int getIdCicle() {
        return idCicle;
    }

    public void setIdCicle(int idCicle) {
        this.idCicle = idCicle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumAlumnes() {
        return numAlumnes;
    }

    public void setNumAlumnes(int numAlumnes) {
        this.numAlumnes = numAlumnes;
    }

    
}
