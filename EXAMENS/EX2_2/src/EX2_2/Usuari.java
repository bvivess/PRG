package EX2_2;

public interface Usuari {
    final String ROLE = "convidat";
    
    public String getROLE();

    public abstract void setROLE(String ROLE);
    
    public default String metodePerDefecte() {
        return this.metodePrivat() + "Mètode per defecte";
    }
    
    private String metodePrivat() {
        return "Privat Intefície";
    }
}
