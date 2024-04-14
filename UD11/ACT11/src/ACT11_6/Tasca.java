package ACT11_6;

import java.time.LocalDate;

public class Tasca {
    private LocalDate data;
    private String descripcio;

    public Tasca(LocalDate data, String titol) {
        this.data = data;
        this.descripcio = titol;
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
        Tasca t = (Tasca) obj;
        return data.equals(t.data);
    }
    
    @Override
    public String toString() {
        return "Tasca = {" + this.data + ", " + this.descripcio + "}";
    }
    
    
}


