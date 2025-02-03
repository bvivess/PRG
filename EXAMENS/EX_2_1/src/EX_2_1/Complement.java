package EX_2_1;

class Complement {
    private String nom;
    private float preu;

    public Complement(String nom, float preu) {
        this.nom = nom;
        this.preu = preu;
    }
  
    public String getNom() {
        return nom;
    }

    public float getPreu() {
        return preu;
    }
    
    @Override
    public String toString() {
        return "Nom: " + this.nom + " Preu: " + this.preu + "EUR";
    }
}
