package ACT11_3;

import java.util.HashMap;

/**
 *
 * @author winadmin
 */
class IPhone10 extends IPhone8 {

    public IPhone10(String marca, Persona persona, HashMap<TipusPatro,String> patrons) {
        super(marca, persona,patrons);
    }

    @Override
    public void setPatrons() {
        super.getPatrons().put(TipusPatro.CODIPIN, null);
        super.getPatrons().put(TipusPatro.TECLAT, null);
        super.getPatrons().put(TipusPatro.EMPREMTA, null);
        super.getPatrons().put(TipusPatro.ROSTRE, null);
    }
}