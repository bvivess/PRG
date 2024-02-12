package ACT11_1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public abstract class Telefon extends ValidadorDispositius implements DispositiuElectronic {
    private String marca;  // Marca del Telèfon
    private Persona persona;  // Dades de la persona propietària
    private boolean onOff;  // Encès o apagat


    public Telefon(HashMap<TipusPatro, String> patrons, String marca, Persona persona, boolean onOff) {
        super(patrons);
        this.marca = marca;
        this.persona = persona;
        this.onOff = onOff;
    }

    public abstract void setPatrons();

    public boolean validaPatrons(Object o) {
        Persona persona = (Persona) o;
        if (this.getOnOff()) {
            for (Map.Entry<TipusPatro, String> eTelefon : this.patrons.entrySet()) {
                TipusPatro patroClauTelefon = eTelefon.getKey();
                String patroValorTelefon = eTelefon.getValue();
                for (Map.Entry<TipusPatro, String> ePersona : persona.getPatrons().entrySet()) {
                    TipusPatro patroClauPersona = ePersona.getKey();
                    String patroValorPersona = ePersona.getValue();
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

    @Override
    public void on() {
        System.out.println("Telèfon encès");
        if (!this.onOff) this.onOff = true;
    }

    @Override
    public void off() {
        System.out.println("Telèfon apagat");
        if (this.onOff) this.onOff = false;
    }

    public boolean getOnOff() {
        return this.onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public HashMap<TipusPatro, String> getPatrons() {
        return patrons;
    }

    @Override
    public String toString() {
        return this.marca;
    }
}