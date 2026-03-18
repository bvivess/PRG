package ACT10_2B;

import java.time.LocalTime;

/**
 * @author T.Vives
 */
class Tasca {
    private LocalTime hora;
    private String titol;

    public Tasca(LocalTime hora, String titol) {
        this.hora = hora;
        this.titol = titol;
    }

    public String getTitol() {
        return this.titol;
    }

    public LocalTime getHora() {
        return this.hora;
    }

    @Override
    public String toString() {
        return hora + " - " + titol;
    }
}