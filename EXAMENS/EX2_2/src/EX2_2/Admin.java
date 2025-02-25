package EX2_2;

public class Admin extends UsuariBase implements Usuari {
    private String nivellAccess;

    public Admin(String nom, String llinatge, String nivellAccess) {
        super(nom, llinatge);
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
        return Usuari.ROLE;  // this.ROLE;  // "Admin";
    }

    @Override
    public void setROLE(String ROLE) {
        //Usuari.ROLE = ROLE;
    }

}
