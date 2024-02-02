package ACT9_1A;

/**
 *
 * @author winadmin
 */
public interface ValidadorDispositius {
 
    abstract void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre);
    abstract boolean validaPatrons(Persona persona);  // Validar Persona amb Dispositiu
 
}

