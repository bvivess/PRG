package ACT8_2B;

/**
 *
 * @author winadmin
 */
public abstract class ValidadorDispositius {
    static final int CODIPIN = 0;  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    static final int TECLAT = 1;
    static final int EMPREMPTA = 2;
    static final int ROSTRE = 3; 
    
    // Diferents sistemes de validació
    private String[] patrons = {null, null, null, null};  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre

    // Constructor
    public ValidadorDispositius(String[] patrons) {
        this.patrons = patrons;
    }
    // Mètode abstracte
    abstract boolean validaPatrons(Object o);  // Validar Persona amb Dispositiu

    // Métode concret
    void setPatrons(String[] patrons) {
        setPatroCodiPin(patrons[CODIPIN]);
        setPatroTeclat(patrons[TECLAT]);
        setPatroEmprempta(patrons[EMPREMPTA]);
        setPatroRostre(patrons[ROSTRE]);
    }
    
    public String getPatroCodiPin() {
        return patrons[CODIPIN];
    }

    public String getPatroTeclat() {
        return patrons[TECLAT];
    }
    
    public String getPatroEmprempta() {
        return patrons[EMPREMPTA];
    }
    
    public String getPatroRostre() {
        return patrons[ROSTRE];
    }

    public void setPatroCodiPin(String patroCodiPin) {
        patrons[CODIPIN] = patroCodiPin;
    }

    public void setPatroTeclat(String patroTeclat) {
        patrons[TECLAT] = patroTeclat;
    }

    public void setPatroEmprempta(String Emprempta) {
        patrons[EMPREMPTA] = Emprempta;
    }

    public void setPatroRostre(String patroRostre) {
        patrons[ROSTRE] = patroRostre;
    }

    public String[] getPatrons() {
        return patrons;
    }
 
}

