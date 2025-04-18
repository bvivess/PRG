package ACT11_6A;

public class Client implements Comparable<Client>{
    int id;
    String nom;
    String email;

    public Client(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    @Override
    public int compareTo(Client c) {
        if (this.id > c.id) return 1;
        else if (this.id < c.id) return -1;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + "," + nom + "," + email;
    }
}