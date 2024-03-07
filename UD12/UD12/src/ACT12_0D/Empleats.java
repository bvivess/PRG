package ACT12_0D;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author winadmin
 */
class Empleats implements Serializable {
    protected Set<Persona> persones;

    public Empleats(Set<Persona> persones) {
        this.persones = persones;
    }    
    
}