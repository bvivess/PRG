package ACT11_4;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public abstract class ValidadorDispositius {
    Map<TipusPatro, String> patrons = new HashMap<>();

    public ValidadorDispositius(Map<TipusPatro, String> patrons) {
        this.patrons = patrons;
    }
    
    // Mètode abstracte
    abstract boolean validaPatrons(Object o);
    
    // Mètode concret
    public void setPatrons() {
        // getPatrons().put(TipusPatro.CODIPIN, null);
        // getPatrons().put(TipusPatro.TECLAT, null);
        // getPatrons().put(TipusPatro.EMPREMTA, null);
        // getPatrons().put(TipusPatro.ROSTRE, null);
    }
    
    public Map<TipusPatro, String> getPatrons() {
        return patrons;
    }
}

