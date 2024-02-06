package ACT9_2B;

/**
 *
 * @author winadmin
 */
public abstract class ValidadorDispositius {
    // Diferents sistemes de validació
    private String[] patrons = {null,null,null,null};  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
 
    abstract void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre);
    abstract boolean validaPatrons(Object o);  // Validar Persona amb Dispositiu
    
    public String getPatroCodiPin() {
        return patrons[0];  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }

    public String getPatroTeclat() {
        return patrons[1];  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }
    
    public String getPatroEmprempta() {
        return patrons[2];  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }
    
    public String getPatroRostre() {
        return patrons[3];  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }

    public void setPatroCodiPin(String patroCodiPin) {
        patrons[0] = patroCodiPin;  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }

    public void setPatroTeclat(String patroTeclat) {
        patrons[1] = patroTeclat;  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }

    public void setPatroEmprempta(String Emprempta) {
        patrons[2] = Emprempta;  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }

    public void setPatroRostre(String patroRostre) {
        patrons[3] = patroRostre;  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }
 
}

