package EX_2_2;

import java.util.ArrayList;

public class Dispositiu {
    private String codiInventari;
    private String nom;
    private int consumBase;
    private ArrayList<Modul> moduls = new ArrayList<>();

    public Dispositiu(String codiInventari, String nom, int consumBase) {
        this.codiInventari = codiInventari;
        this.nom = nom;
        this.consumBase = consumBase;
        this.moduls = new ArrayList<>();
    }

    public boolean afegeixModul(Modul m) {
        if (this.moduls.indexOf(m) == -1)
            return moduls.add(m);
        return false;
    }
    
    public boolean eliminaModul(String nom) {
        return moduls.remove(new Modul(nom));
    }
    
    public int calculaConsum() {
        return this.consumBase + this.sumaConsumModuls();
    }

    protected int sumaConsumModuls() {
        int total = 0;
        for (Modul m : this.moduls)
            total += m.getConsum();
        
        return total;
    }

    protected int getConsumBase() {
        return consumBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dispositiu)) return false;
        Dispositiu d = (Dispositiu) o;
        return this.codiInventari.equals(d.codiInventari);
    }

    @Override
    public String toString() {
        String text = "Codi inventari: " + this.codiInventari + " Nom: " + this.nom + " Consum base: " + this.consumBase + "W \n";
        text += "Mòduls: \n";
        for (Modul m : this.moduls)
            text += "\t" + m.toString() + "\n";

        return text;
    }
}
