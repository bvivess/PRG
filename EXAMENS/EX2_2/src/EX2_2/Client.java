package EX2_2;

public class Client extends UsuariBase implements Usuari  {
    private String adreca;

    public Client(String nom, String llinatge, String adreca) {
        super(nom, llinatge);
        this.adreca = adreca;
    }

    @Override
    public String metodePerDefecte() {
        return this.metodePrivat() + " | Default SubClasse2";
    }
    
    private String metodePrivat() {
        return "Privat SubClasse2";
    }

    @Override
    public String getROLE() {
        return Admin.ROLE;  // "Client";
    }

    @Override
    public void setROLE(String ROLE) {
        //Classe1.ROLE = ROLE;
    }

}