package EX2_3;

import java.util.ArrayList;

// Classe Menu
public class Menu implements UtilMenjar{
    protected String nom;
    protected ArrayList<Plat> plats;

    public Menu(String nom) {
        this.nom = nom;
        this.plats = new ArrayList<>();
    }

    public boolean afegeixPlat(Plat p) {
        for (Plat plat : this.plats)
            if ((plat.getClass().equals(p.getClass())) )  // || plat.equals(p)) --> NO ES DEMANA A L'ENUNCIAT
                return false;
        return plats.add(p);
    }
    
    public boolean eliminaPlat(String nom) {
        return plats.removeIf(plat -> plat.getNom().equals(nom));
    }
    
    @Override
    public double calculaPreu() {
        double total = 0;
        for (Plat p : this.plats) 
            total += p.calculaPreu();
        
        return total;
    }
    
    @Override
    public boolean esPerVegetarians() {
        for (Plat p : this.plats) 
            if (!(p.esPerVegetarians()))
                return false;
        return true;
    }

    @Override
    public boolean esPerCeliacs() {
        for (Plat p : this.plats) 
            if (!(p.esPerCeliacs()))
                return false;
        return true;
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
        
        final Menu m = (Menu) obj;
        return this.nom.equals(m.nom);
    }

    @Override
    public String toString() {
        String text = "Menu: " + this.nom + " Vegetarians: " + this.esPerVegetarians() + " Celiacs: " + this.esPerCeliacs() + " Preu: " + this.calculaPreu();
                
        text += "\n\t\tPlats del menu:";
        for (Plat p : this.plats)
            text += "\n\t\t\t" + p.toString();
        
        return text;
    }
    
}
