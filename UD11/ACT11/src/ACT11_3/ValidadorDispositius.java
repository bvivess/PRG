package ACT11_3;

import java.util.HashMap;

/**
 *
 * @author winadmin
 */
public abstract class ValidadorDispositius {
    HashMap<TipusPatro, String> patrons = new HashMap<>();

    public ValidadorDispositius(HashMap<TipusPatro, String> patrons) {
        this.patrons = patrons;
    }

    abstract void setPatrons();
    abstract boolean validaPatrons(Object o);
}

