package EX_2_1;

public class Component {
    private String nom;
    private int consum;

    public Component(String nom, int consum) {
        this.nom = nom;
        this.consum = consum;
    }
    
    public Component(String nom) {
        this.nom = nom;
    }

    public int getConsum() {
        return consum;
    }

    @Override
    public String toString() {
        return nom + " (" + consum + "W)";
    }
}
