package ACT11_6;

import java.time.LocalDate;

public class Tasca {
    private LocalDate dia;
    private String titol;

    public Tasca(LocalDate dia, String titol) {
        this.dia = dia;
        this.titol = titol;
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
        return dia.equals(other.dia);
    }
    
    @Override
    public String toString() {
        return "Tasca = {" + this.dia + ", " + this.titol + "}";
    }
    
    
}


