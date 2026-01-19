package ACT6_1B;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Cicle {
    private int idCicle;
    private String nom;
    private int numAlumnes;
    private ArrayList<Modul> moduls;
    //
    public static int comptadorCicles=1;

    public Cicle(int idCicle, String nom, int numAlumnes) {
        this.setIdCicle(idCicle);
        this.setNom(nom);
        this.setNumAlumnes(numAlumnes);
        this.moduls = new ArrayList<Modul> ();
    }

    // Mòduls    
    public String mostraCicle() {
        String text;
        
        text = "Cicle: " + "ID=" + this.idCicle + ", nom=" + this.nom + ", numAlumnes=" + this.numAlumnes + "; \n" + "Mòduls: {";
        for (Modul m : moduls) {
            text += "\n\t\t" + m.mostraModul();
        }
        text += "}";
        
        return text;
    }   
    
    public int cercaModul(String nom) {
        for (int i=0; i<this.moduls.size(); i++) {
            if (this.moduls.get(i).getNom().equalsIgnoreCase(nom)) {
                return i;
            }
        }
        return -1;
    }
    
    public void afegeixModul(Modul modul) {
        this.moduls.add(modul);
    }
    
    public boolean eliminaModul(String nom) {
        int i = this.cercaModul(nom);
        
        if (i >= 0) {
            this.moduls.remove(i);
            return true;
        }
        return false;
    }

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

    public static int getComptadorCicles() {
        return Cicle.comptadorCicles;
    }

    public static void setComptadorCicles(int comptadorCicles) {
        Cicle.comptadorCicles = comptadorCicles;
    }
    
}
