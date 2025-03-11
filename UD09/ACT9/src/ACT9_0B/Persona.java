package ACT9_0B;

abstract class Persona {
    private String nom;
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
   
    public abstract void saluda();

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }
    
}

