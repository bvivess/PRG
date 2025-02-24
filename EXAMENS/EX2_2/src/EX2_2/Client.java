package EX2_2;

public class Client extends UsuariBase implements Usuari  {
    private String adreca;

    public Client(String b1, String b2, String adreca) {
        super(b1, b2);
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
        return Admin.ROLE;
    }

    @Override
    public void setROLE(String a1) {
        //Classe1.a1 = a1;
    }

}