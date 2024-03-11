package ACT11_2;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Representa cada un dels moduls associats a un cicle formatiu
 * @author T.Vives
 */
public class Dia {
    protected LocalDate data = LocalDate.now();
    protected Queue<String> tasques = new LinkedList<>();

    // Constructor
    public Dia(LocalDate data, Queue<String> tasques) {
        this.data = data;
        this.tasques = tasques;
    }
    
    // Getters i Setters
    @Override
    public int hashCode() {
        return 31 * (Objects.hashCode(this.data));
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
        final Dia other = (Dia) obj;
        return Objects.equals(this.data, other.data);
    }
    
    @Override
    public String toString() {
        return tasques.toString();
    }
}
