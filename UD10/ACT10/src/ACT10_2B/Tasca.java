package ACT10_2B;

import java.time.LocalTime;
import java.util.Objects;

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
    
    public Tasca(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.hora);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tasca other = (Tasca) obj;
        return Objects.equals(this.hora, other.hora);
    }

    public String getTitol() {
        return this.titol;
    }

    public LocalTime getHora() {
        return this.hora;
    }

    @Override
    public String toString() {
        return this.hora + " - " + this.titol;
    }
}