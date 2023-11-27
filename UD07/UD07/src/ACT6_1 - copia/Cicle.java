package ACT6_1;

/**
 *
 * @author T.Vives
 */
public class Cicle {
    public  int idCicle;
    public String nom;
    public int numAlumnes;
    //
    public static int comptadorCicles = 1;

    // Constructor
    public Cicle(String nom, int numAlumnes) {
        this.idCicle = getComptadorCicles();
        this.nom = nom;
        this.numAlumnes = numAlumnes;
    }
    
    // Mòduls
    public String mostraCicle() {
        String text;
        
        text = "Cicle " + "ID=" + idCicle + ", nom=" + nom + ", numAlumnes=" + numAlumnes;
        
        return text;
    }
    
    // Getters
    public int getIdCicle() {
        return idCicle;
    }

    public String getNom() {
        return nom;
    }

    public int getNumAlumnes() {
        return numAlumnes;
    }

    public static int getComptadorCicles() {
        return comptadorCicles++;
    }
    
    // Setters
    public void setIdCicle(int idCicle) {
        this.idCicle = idCicle;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumAlumnes(int numAlumnes) {
        this.numAlumnes = numAlumnes;
    }
    
}
