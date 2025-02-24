package EX2_2;

public class Moderador extends Client {

    public Moderador(String b1, String b2, String d1) {
        super(b1, b2, d1);
    }
    
    private String metodePrivat() {
        return "Privat SubClasse3";
    }
    
    @Override
    public String getROLE() {
        return Admin.ROLE;  // "Moderador";
    }

    @Override
    public void setROLE(String ROLE) {
        //Classe1.ROLE = ROLE;
    }
}