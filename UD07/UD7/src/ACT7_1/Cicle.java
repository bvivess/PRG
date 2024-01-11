package ACT7_1;

import java.util.ArrayList;

/**
 * Representa cada una de les classes d'un cicle formatiu
 * @author T.Vives
 */
public class Cicle {
    private  int idCicle;
    private String nom;
    private int numAlumnes;
    private ArrayList<Modul> moduls;
    //
    private static int comptadorCicles = 1;

    // Constructors
    public Cicle(String nom, int numAlumnes) {
        this.idCicle = getComptadorCicles();
        this.nom = nom;
        this.numAlumnes = numAlumnes;
        this.moduls = new ArrayList<>();
    }
    
    public Cicle(String nom, int numAlumnes, ArrayList<Modul> moduls) {
        this.idCicle = getComptadorCicles();
        this.nom = nom;
        this.numAlumnes = numAlumnes;
        this.moduls = new ArrayList<>(moduls);
    }

    // Mòduls
    public void afegeixModul(Modul nouModul) {
        this.moduls.add(nouModul);
    }
    
    public String mostraCicle() {
        String text;
        
        text = "Cicle " + "ID=" + idCicle + ", nom=" + nom + ", numAlumnes=" + numAlumnes + 
                "; \n\t" +
                "Mòduls: {";
        for (Modul m: moduls) {
            text = text + m.getIdModul() + "-" + m.getNom() + " ";
        }
        text = text +"}";
        
        return text;
    }   
    
    // *****************************
    private int cercarModul(String nom) {
        for (int i=0; i<moduls.size(); i++) {
            if (moduls.get(i).getNom().equalsIgnoreCase(nom)) {
                return i;
            }
        }
        return -1;
    }
 
    public boolean eliminarModul(String nom) {
        int i = cercarModul(nom);
        
        if (i >= 0) {
            moduls.remove(i);
            return true;
        }
        return false;
    }
    
    // *****************************
    // Getters i Setters
    public int getIdCicle() {
        return idCicle;
    }

    public String getNom() {
        return nom;
    }

    public int getNumAlumnes() {
        return numAlumnes;
    }

    public ArrayList<Modul> getModuls() {
        return moduls;
    }

    public static int getComptadorCicles() {
        return Cicle.comptadorCicles++;
    }

    public void setIdCicle(int idCicle) {
        this.idCicle = idCicle;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumAlumnes(int numAlumnes) {
        this.numAlumnes = numAlumnes;
    }

    public static void setComptadorCicle(int comptadorCicles) {
        Cicle.comptadorCicles = comptadorCicles;
    } 
    
}
