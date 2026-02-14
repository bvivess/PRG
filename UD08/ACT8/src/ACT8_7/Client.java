package ACT8_7;

import java.util.ArrayList;
import java.util.Objects;

public class Client {
    private String nom;
    private ArrayList<Llibre> llibresPrestats;

    public Client(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();
    }
    
    public boolean afegeixLlibrePrestat(Llibre llibre) {
        if (!(this.llibresPrestats.contains(llibre)))
            return llibresPrestats.add(llibre);
        return false;
    }

    // Getters i setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nom);
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
        final Client other = (Client) obj;
        return Objects.equals(this.nom, other.nom);
    }

    public ArrayList<Llibre> getLlibresPrestats() {
        return llibresPrestats;
    }

    public void setLlibresPrestats(ArrayList<Llibre> llibresPrestats) {
        this.llibresPrestats = llibresPrestats;
    }

    @Override
    public String toString() {
        String text = "Client: " + "nom=" + nom;
        text += "\n\tLlibres prestats:" + llibresPrestats;
        for (Llibre llibre : this.llibresPrestats)
            text += "\n\t" + llibre.toString();
            
        return text;
    }
    
}