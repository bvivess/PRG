package EXTRAORD;

abstract class Persona {
    protected String nom;
    protected int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
    
    public abstract void assignaConductor(Vehicle v);
}
