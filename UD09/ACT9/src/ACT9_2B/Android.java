package ACT9_2B;

/**
 *
 * @author winadmin
 */
public class Android extends Telefon {
    private String[] patrons = {null,null,null,null};  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
 
    // Constructors
    public Android(String marca, Persona persona, String patroCodiPin, String patroTeclat, String patroEmprempta) {
        super(marca, persona, false);
        setPatroCodiPin(patroCodiPin);
        setPatroTeclat(patroTeclat);
        setPatroEmprempta(patroEmprempta);
    }
    
    /** Constructor sense patrons, a continuació utilizar 'setPatrons'
     * 
     * @param marca
     * @param persona 
     */
    public Android(String marca, Persona persona) {
        super(marca, persona, false);
    }

    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        setPatroCodiPin(patroCodiPin);
        setPatroTeclat(patroTeclat);
        setPatroEmprempta(patroEmprempta);
    }
    
    @Override
    public boolean validaPatrons(Object o) {
        Persona persona = (Persona) o;
        if (super.getOnOff()) {
            if (persona.getPatroCodiPin() != null) 
                return persona.getPatroCodiPin().equals(this.getPatroCodiPin());
            if (persona.getPatroTeclat() != null) 
                return persona.getPatroTeclat().equals(this.getPatroTeclat());
            if (persona.getPatroEmprempta() != null) 
                return persona.getPatroEmprempta().equals(this.getPatroEmprempta());
            return false;
        } else {
            System.out.println("Telèfon Android no encès");
            return false;
        }
    }

    @Override
    public String getPatroCodiPin() {
        return patrons[0];  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }

    @Override
    public String getPatroTeclat() {
        return patrons[1];  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }
    
    @Override
    public String getPatroEmprempta() {
        return patrons[2];  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }
    
    @Override
    public String getPatroRostre() {
        return null;
    }
    
    public void setPatroCodiPin(String patroCodiPin) {
        patrons[0] = patroCodiPin;  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }

    public void setPatroTeclat(String patroTeclat) {
        patrons[1] = patroTeclat;  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }
    public void setPatroEmprempta(String patroEmprempta) {
        patrons[2] = patroEmprempta;  // patroCodiPin, patroTeclat, patroEmprempta, patroRostre
    }
 

}
