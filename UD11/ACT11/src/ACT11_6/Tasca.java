package ACT11_6;

import java.time.LocalDate;



public class Tasca {
    private LocalDate hora;
    private String titol;

    public Tasca(LocalDate hora, String titol) {
        this.hora = hora;
        this.titol = titol;
    }

    public LocalDate getNumero() {
        return this.hora;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tasca other = (Tasca) obj;
        return hora.equals(other.hora);
    }
    
    @Override
    public String toString() {
        return "Tasca = {" + this.hora + ", " + this.titol + "}";
    }
    
    
}


