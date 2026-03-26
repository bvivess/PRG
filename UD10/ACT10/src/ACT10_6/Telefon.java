package ACT10_6;

import java.util.Map;

/**
 *
 * @author winadmin
 */
public abstract class Telefon extends ValidadorDispositius implements DispositiuElectronic {
    private String marca;  // Marca del Telèfon
    private Persona persona;  // Dades de la persona propietària
    private boolean onOff;  // Encès o apagat


    public Telefon(Map<TipusPatro, String> patrons, String marca, Persona persona, boolean onOff) {
        super(patrons);
        this.marca = marca;
        this.persona = persona;
        this.onOff = onOff;
    }

    /*
    public boolean validaPatrons(Object o) {
        Persona persona = (Persona) o;
        if (this.getOnOff()) {
            for (Map.Entry<TipusPatro, String> entryTelefon : this.patrons.entrySet()) {
                TipusPatro patroClauTelefon = entryTelefon.getKey();
                String patroValorTelefon = entryTelefon.getValue();
                for (Map.Entry<TipusPatro, String> entryPersona : persona.getPatrons().entrySet()) {
                    TipusPatro patroClauPersona = entryPersona.getKey();
                    String patroValorPersona = entryPersona.getValue();
                    if (patroClauTelefon == patroClauPersona)
                        return patroClauTelefon.equals(patroClauPersona);
                }
            }
            return false;
        } else {
            System.out.println("Telèfon no encès");
            return false;
        }
    }*/

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

    @Override
    public String toString() {
        return this.marca;
    }
}