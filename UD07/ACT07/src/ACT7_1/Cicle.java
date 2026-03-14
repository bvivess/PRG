package ACT7_1;

import java.util.ArrayList;
import java.util.Objects;

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
    public void afegeixModul(Modul modul) {
        this.moduls.add(modul);
    }
    
    public int cercaModul(String nom) {
        return this.moduls.indexOf( new Modul(0, nom, 0 ) );
    }

    public boolean eliminaModul(String nom) {
        return this.moduls.remove( new Modul(0, nom, 0 ) );
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cicle other = (Cicle) obj;
        return Objects.equals(this.nom, other.nom);
    }
    
    public String toString() {
        String text;
        
        text = "Cicle: " + "ID=" + this.idCicle + ", nom=" + this.nom + ", numAlumnes=" + this.numAlumnes + "; \n" + "Mòduls: {";
        for (Modul m : moduls) {
            text += "\n\t\t" + m.toString();
        }
        text += "}";
        
        return text;
    }
    
}
