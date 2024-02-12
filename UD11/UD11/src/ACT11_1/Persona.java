package ACT11_1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public class Persona extends ValidadorDispositius {
    private String nom;

    Persona(String nom, HashMap<TipusPatro, String> patrons) {
        super(patrons);
        setNom(nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public HashMap<TipusPatro, String> getPatrons() {
        return patrons;
    }

    @Override
    public void setPatrons() {
        this.patrons = patrons;
    }
    
    @Override
    public boolean validaPatrons(Object o) {
        Telefon telefon = (Telefon) o;
        if (telefon.getOnOff()) {
            for (Map.Entry<TipusPatro, String> ePersona : this.patrons.entrySet()) {
                TipusPatro patroClauPersona = ePersona.getKey();
                String patroValorPersona = ePersona.getValue();
                for (Map.Entry<TipusPatro, String> eTelefon : telefon.getPatrons().entrySet()) {
                    TipusPatro patroClauTelefon = eTelefon.getKey();
                    String patroValorTelefon = eTelefon.getValue();
                    if (patroClauTelefon == patroClauPersona)
                        return patroClauTelefon.equals(patroClauPersona);
                }
            }
            return false;
        } else {
            System.out.println("Telèfon no encès");
            return false;
        }
    }
}