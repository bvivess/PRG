package ACT11_6B.Classes;

public class Client {
    private int id;
    private String nom;
    private String telefon;
    private String email;

    public Client(int id, String nom, String telefon, String email) {
        this.id = id;
        this.nom = nom;
        this.telefon = telefon;
        this.email = email;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", telefon=" + telefon + ", email=" + email + '}';
    }

    
}