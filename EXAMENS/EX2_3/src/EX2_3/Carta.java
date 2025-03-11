package EX2_3;

import java.util.ArrayList;

// Classe Carta
public class Carta {
    private ArrayList<Menu> menus;
    private ArrayList<Plat> plats;
    private ArrayList<Beguda> begudes;

    public Carta() {
        this.menus = new ArrayList<>();
        this.plats = new ArrayList<>();
        this.begudes = new ArrayList<>();
    }
    
    // Afegeix-Elimina Menu 
    // Fet com l'exercici 8.8
    // NO ES DEMANA A L'ENUNCIAT
    public boolean afegeixMenu(Menu m) {
        if (!(this.menus.contains(m)))
            return this.menus.add(m);
        return false;
    }
        
    public boolean eliminaMenu(String nom) {
        return (menus.remove(cercaMenu(nom)) == null ? false:true);
    }
    
    private int cercaMenu(String nom) {
        int index = 0;
        
        for (Menu m : menus) {
            if (m.nom.equals(nom))
                return index;
            index++;
        }
        
        return -1;
    }
    
    // Afegeix-Elimina Plat
    // Fent la cerca directament
    //     - amb programació imperativa
    //     - amb programació funcional
    public boolean afegeixPlat(Plat p) { 
        for (Plat plat : this.plats)
            if (plat.nom.equals(p.nom))
                return false;
        return plats.add(p);
    }
    
    public boolean eliminaPlat(String nom) {
        return plats.removeIf(plat -> plat.getNom().equals(nom));
    }
    
    // Afegeix-Elimina Beguda
    public boolean afegeixBeguda(Beguda b) { 
        for (Beguda beguda : this.begudes)
            if (beguda.nom.equals(b.nom))
                return false;
        return begudes.add(b);
    }
    
    public boolean eliminaBeguda(String nom) {
        return begudes.removeIf(beguda -> beguda.getNom().equals(nom));
    }

    @Override
    public String toString() {
        String text = "CARTA:\n\t MENUS:";

        for (Menu m : this.menus) 
            text += "\n\t\t" + m.toString();
        
        text += "\n\t PLATS:";
        for (Plat p : this.plats)
            text += "\n\t\t" + p.toString();

        text += "\n\t BEGUDES:";
        for (Beguda b : this.begudes)
            text += "\n\t\t" + b.toString();

        
        return text;
    }

}
