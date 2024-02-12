package ACT11_1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author winadmin
 */

class IPhone8 extends Telefon {

    public IPhone8(String marca, Persona persona, HashMap<TipusPatro,String> patrons) {
        super(patrons,marca, persona, false);
    }

    @Override
    public void setPatrons() {
        super.getPatrons().put(TipusPatro.CODIPIN, null);
        super.getPatrons().put(TipusPatro.TECLAT, null);
        super.getPatrons().put(TipusPatro.EMPREMTA, null);
        super.getPatrons().put(TipusPatro.ROSTRE, null);
    }
}