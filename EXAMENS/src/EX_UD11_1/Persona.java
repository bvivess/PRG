package EX_UD11_1;

public class Persona {
    private String nom;
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    public int getEdat() {
        return edat;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", edat=" + edat + '}';
    }
    
}
