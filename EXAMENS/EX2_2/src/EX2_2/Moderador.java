package EX2_2;

public class Moderador extends Client {

    public Moderador(String nom, String llinatge, String adreca) {
        super(nom, llinatge, adreca);
    }
  
    private String metodePrivat() {
        return "Privat SubClasse3";
    }
    
    @Override
    public String getROLE() {
        return Usuari.ROLE;  // this.ROLE;  // "Moderador"
    }

    @Override
    public void setROLE(String ROLE) {
        //Usuari.ROLE = ROLE;
    }
}