package EX2_2;

public abstract class UsuariBase {
    protected String nom;
    protected String llinatge;

    public UsuariBase(String nom, String llinatge) {
        this.nom = nom;
        this.llinatge = llinatge;
    }
    
    public String metodeConcret() {
        return this.metodePrivat() + "Mètode concret";
    }
    
    private String metodePrivat() {
        return "Privat Abstracte";
    }
}
