package ACT8_8;

import java.util.Objects;

public class Reparacio {
    String descripcio;
    double preu;

    public Reparacio(String descripcio, double preu) {
        this.descripcio = descripcio;
        this.preu = preu;
    }

    public String getDescripcio() {
        return descripcio;
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
        final Reparacio other = (Reparacio) obj;
        return Objects.equals(this.descripcio, other.descripcio);
    }

    @Override
    public String toString() {
        return "Reparacio {" + "descripcio=" + this.descripcio + ", preu=" + this.preu + '}';
    }
    
}
