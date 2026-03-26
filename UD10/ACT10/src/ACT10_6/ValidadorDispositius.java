package ACT10_6;

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
    
    // Mètode abstracte
    // abstract boolean validaPatrons(Object o);
    // Mètode comú per validar patrons
    public boolean validaPatrons(ValidadorDispositius altre) {
        if (altre instanceof Telefon && !((Telefon) altre).getOnOff()) {
            System.out.println("Telèfon no encès");
            return false;
        }

        for (Map.Entry<TipusPatro, String> entryA : this.patrons.entrySet()) {
            TipusPatro clauA = entryA.getKey();
            String valorA = entryA.getValue();

            for (Map.Entry<TipusPatro, String> entryB : altre.patrons.entrySet()) {
                TipusPatro clauB = entryB.getKey();
                String valorB = entryB.getValue();

                if (clauA.equals(clauB) ) {
                    return valorA.equals(valorB); // Retorna true només si clau i valor coincideixen
                }
            }
        }
        return false;
    }

    
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

