package ACT11_6A.Classes;

import ACT11_6A.Classes.Categoria;

public class Producte implements Comparable <Producte>{
    int id;
    String nom;
    double preu;
    Categoria categoria;

    public Producte(int id, String nom, double preu, Categoria categoria) {
        this.id = id;
        this.nom = nom;
        this.preu = preu;
        this.categoria = categoria;
    }

    @Override
    public int compareTo(Producte p) {
        if (this.id > p.id) return 1;
        else if (this.id < p.id) return -1;
        else return 0;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return id + "," + nom + "," + preu + "," + categoria;
    }
}
