package ACT10_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author winadmin
 */
public abstract class ValidadorDispositius {
    Map<TipusPatro, String> patrons = new HashMap<>();

    public ValidadorDispositius(Map<TipusPatro, String> patrons) {
        this.patrons = patrons;
    }
    
    // M�tode abstracte
    // abstract boolean validaPatrons(Object o);
    // M�tode com� per validar patrons
    public boolean validaPatrons(ValidadorDispositius altre) {
        if (altre instanceof Telefon && !((Telefon) altre).getOnOff()) {
            System.out.println("Tel�fon no enc�s");
            return false;
        }

        for (Map.Entry<TipusPatro, String> entryA : this.patrons.entrySet()) {
            TipusPatro clauA = entryA.getKey();
            String valorA = entryA.getValue();

            for (Map.Entry<TipusPatro, String> entryB : altre.patrons.entrySet()) {
                TipusPatro clauB = entryB.getKey();
                String valorB = entryB.getValue();

                if (clauA.equals(clauB) ) {
                    return valorA.equals(valorB); // Retorna true nom�s si clau i valor coincideixen
                }
            }
        }
        return false;
    }

    
    // M�tode concret
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

