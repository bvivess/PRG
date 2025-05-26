package ex_final;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable {
    private Usuari usuari;
    private Activitat activitat;
    private LocalDate data;

    public Reserva(Usuari usuari, Activitat activitat, LocalDate data) {
        this.usuari = usuari;
        this.activitat = activitat;
        this.data = data;
    }

    public Usuari getUsuari() { return usuari; }
    public Activitat getActivitat() { return activitat; }
    public LocalDate getData() { return data; }

    @Override
    public String toString() {
        return usuari.getNom() + " ha reservat '" + activitat.getDescripcio() + "' per al " + data;
    }
}
