package ACT6_2;

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
    public static int comptadorCicles = 0;

    // Mòduls
    // Bloc estàtic per incrementar el comptador
    static {
        comptadorCicles++;
    }
    
    public void afegeixModul(Modul modul) {
        moduls.add(modul);
    }
    
    public String mostraCicle() {
        String text;
        
        text = "Cicle " + "ID=" + idCicle + ", nom=" + nom + ", numAlumnes=" + numAlumnes + "; Mòduls: {";
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
    
}
