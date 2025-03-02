package ACT8_9;

// Classe Menú que conté diferents plats

import java.util.ArrayList;

class Menu{
    private String nom;
    private ArrayList<Plat> plats;

    public Menu(String nom, PrimerPlat primer, SegonPlat segon, Postre postre) {
        this.nom = nom;
        this.plats = new ArrayList<Plat>();
    }

    public double calculaPreuTotal() {
        double total = 0;
        for (Plat p: this.plats)
            total += p.calculaPreuFinal();
        
        return total;
    }

    @Override
    public String toString() {
        String text = "Menú: " + nom + "\n";
        for (Plat p: this.plats)
            text += "- " + p.toString() + "\n";
        
        text += "Total: " + calculaPreuTotal() + "¤\n";
        
        return text;
    }
}
