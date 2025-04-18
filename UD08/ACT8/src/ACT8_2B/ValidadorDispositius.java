package ACT8_2B;

/**
 *
 * @author winadmin
 */
public abstract class ValidadorDispositius {
    static final int CODIPIN = 0;
    static final int TECLAT = 1;
    static final int EMPREMPTA = 2;
    static final int ROSTRE = 3; 
    
    // Diferents sistemes de validaci�
    private String[] patrons = {null, null, null, null};  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre

    // Constructor
    public ValidadorDispositius(String[] patrons) {
        this.patrons = patrons;
    }
    // M�tode abstracte
    /* abstract boolean validaPatrons(Object o);  // Validar Persona amb Dispositiu o viceversa */
    
    public boolean validaPatrons(Object o) {
        if (!(o instanceof ValidadorDispositius)) {
            return false;  // Si no �s un ValidadorDispositius, no es pot validar
        }

        ValidadorDispositius validadorDispositiu = (ValidadorDispositius) o;

        // Si l'objete actual �s un Tel�fon, cal mirar si est� enc�s
        if (this instanceof Telefon && !((Telefon) this).getOnOff()) {
            System.out.println("Tel�fon no enc�s");
            return false;
        }

        // Si l'objete rebut �s un Tel�fon, cal mirar si est� enc�s
        if (validadorDispositiu instanceof Telefon && !((Telefon) validadorDispositiu).getOnOff()) {
            System.out.println("Tel�fon no enc�s");
            return false;
        }

        // Comprovaci� dels patrons
        for (String patroActual : this.getPatrons()) {
            for (String patroObjecte : validadorDispositiu.getPatrons()) {
                if (patroActual != null && patroActual.equals(patroObjecte)) {
                    return true;  // Coincid�ncia en els patrons
                }
            }
        }

        return false;  // No s'han trobat coincid�ncies
    }

    // M�tode concret
    void setPatrons(String[] patrons) {
        setPatroCodiPin(patrons[CODIPIN]);
        setPatroTeclat(patrons[TECLAT]);
        setPatroEmprempta(patrons[EMPREMPTA]);
        setPatroRostre(patrons[ROSTRE]);
    }
    
    public String getPatroCodiPin() {  // si es vol reutilitzar 'getPatroCodiPin()'
        return patrons[CODIPIN];
    }

    public String getPatroTeclat() {  // si es vol reutilitzar 'getPatroTeclat()'
        return patrons[TECLAT];
    }
    
    public String getPatroEmprempta() {  // si es vol reutilitzar 'getPatroEmprempta()'
        return patrons[EMPREMPTA];
    }
    
    public String getPatroRostre() {  // si es vol reutilitzar 'getPatroRostre()'
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

