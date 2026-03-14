package ACT5_1B;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Cicle {
    public int idCicle;
    public String nom;
    public int numAlumnes;
    public ArrayList<Modul> moduls;
    //
    public static int comptadorCicles=1;

    // Mòduls    
    public String mostraCicle() {
        String text;
        
        text = "Cicle: " + "ID=" + this.idCicle + ", nom=" + this.nom + ", numAlumnes=" + this.numAlumnes + "Mòduls: {";
        for (Modul m : moduls) {
            text += "; \n\t" + m.mostraModul();
        }
        text += "}";
        
        return text;
    }   
    
    private int cercaModul(String nom) {
        for (int i=0; i<moduls.size(); i++) {
            if (moduls.get(i).nom.equalsIgnoreCase(nom)) {
                return i;
            }
        }
        return -1;
    }
    
    public void afegeixModul(Modul modul) {
        moduls.add(modul);
    }
    
    public boolean eliminaModul(String nom) {
        int i = cercaModul(nom);
        
        if (i >= 0) {
            moduls.remove(i);
            return true;
        }
        return false;
    }
    
}
