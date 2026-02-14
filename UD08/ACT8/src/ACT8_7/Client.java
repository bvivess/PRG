package ACT8_7;

import java.util.ArrayList;

public class Client {
    private String nom;
    private String llinatge;
    private ArrayList<Llibre> llibresPrestats;

    public Client(String nom, String cognom) {
        this.nom = nom;
        this.llinatge = cognom;
        this.llibresPrestats = new ArrayList<>();
    }

    public void prestaLlibre(Llibre llibre) {
        llibresPrestats.add(llibre);
    }

    // Getters i setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatge() {
        return llinatge;
    }

    public void setLlinatge(String llinatge) {
        this.llinatge = llinatge;
    }

    public ArrayList<Llibre> getLlibresPrestats() {
        return llibresPrestats;
    }

    public void setLlibresPrestats(ArrayList<Llibre> llibresPrestats) {
        this.llibresPrestats = llibresPrestats;
    }
}