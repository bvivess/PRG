package EX2_2;

public class Admin extends UsuariBase implements Usuari {
    private String nivellAccess;

    public Admin(String b1, String b2, String nivellAccess) {
        super(b1, b2);
        this.nivellAccess = nivellAccess;
    }

    @Override
    public String metodePerDefecte() {
        return this.metodePrivat() + " | Default SubClasse1";
    }
    
    private String metodePrivat() {
        return "Privat SubClasse1";
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
