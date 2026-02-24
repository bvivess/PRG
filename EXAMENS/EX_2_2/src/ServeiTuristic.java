import java.util.ArrayList;
import java.util.Objects;

public abstract class ServeiTuristic implements Comercialitzable, Promocionable {
    protected String nom;
    protected ArrayList<Caracteristica> caracteristiques;

    public ServeiTuristic(String nom) {
        this.nom = nom;
        this.caracteristiques = new ArrayList<>();
    }

    public String getNom() { return nom; }

    public boolean afegeixCaracteristica(Caracteristica c) {
        for (Caracteristica carac : caracteristiques) {
            if (carac.getNom().equals(c.getNom())) return false;
        }
        caracteristiques.add(c);
        return true;
    }
    
    public boolean eliminaCaracteristica(String n) {
        return true;
    }
    
    @Override
    public double calculaPreu() {  // Calcula Preu Base
        double total = 0;
        for (Caracteristica c : this.caracteristiques) {
            total += c.getPreuCaracteristica();
        }
        return total;
    }

    @Override
    public boolean esPremium() {
        if (caracteristiques.isEmpty()) return false;
        for (Caracteristica c : caracteristiques) {
            if (!c.esPremium()) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nom);
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
        final ServeiTuristic other = (ServeiTuristic) obj;
        return Objects.equals(this.nom, other.nom);
    }

    @Override
    public String toString() {
        String text =  "Servei: " + nom + ", Premium: " + this.esPremium() + ", Sostenible: " + this.esSostenible();
        text += "\n\tCaracterístiques del servei:";
        for (Caracteristica c : this.caracteristiques) {
            text += "\n\t\t" + c.toString();
        }
        text += "\n\t\tPREU SERVEI: " + this.calculaPreu();
        return text;
    }
}