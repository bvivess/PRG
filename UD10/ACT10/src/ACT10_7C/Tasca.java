package ACT10_7C;

import java.time.LocalDateTime;
import java.util.Objects;

public class Tasca {
    private LocalDateTime dataHora;
    private String descripcio;

    public Tasca(LocalDateTime dataHora, String titol) {
        this.dataHora = dataHora;
        this.descripcio = titol;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.dataHora);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tasca t = (Tasca) o;
        return dataHora.equals(t.dataHora);
    }
    
    @Override
    public String toString() {
        return "Tasca = {" + this.dataHora + ", " + this.descripcio + "}";
    }
    
    
}


