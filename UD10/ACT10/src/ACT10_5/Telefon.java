package ACT10_5;

import java.util.Map;

/**
 *
 * @author winadmin
 */
public abstract class Telefon extends ValidadorDispositius implements DispositiuElectronic {
    private String marca;  // Marca del Tel�fon
    private Persona persona;  // Dades de la persona propiet�ria
    private boolean onOff;  // Enc�s o apagat


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
            System.out.println("Tel�fon no enc�s");
            return false;
        }
    }*/

    @Override
    public void on() {
        System.out.println("Tel�fon enc�s");
        if (!this.onOff) this.onOff = true;
    }

    @Override
    public void off() {
        System.out.println("Tel�fon apagat");
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