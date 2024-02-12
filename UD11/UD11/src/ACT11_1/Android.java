package ACT11_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Android que extiende de la clase Telefon.
 */
class Android extends Telefon {
    public Android(String marca, Persona persona, HashMap<TipusPatro,String> patrons) {
        super(patrons, marca, persona, false);
    }

    @Override
    public void setPatrons() {
        super.getPatrons().put(TipusPatro.CODIPIN, null);
        super.getPatrons().put(TipusPatro.TECLAT, null);
        super.getPatrons().put(TipusPatro.EMPREMTA, null);
        super.getPatrons().put(TipusPatro.ROSTRE, null);
    }
    

}

