package EX_UD11_3;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tasca {
    private LocalDate dia;
    private String tarea;

    public Tasca(LocalDate dia, String tarea) {
        this.dia = dia;
        this.tarea = tarea;
    }

    public LocalDate getDia() {
        return dia;
    }

    public String getTarea() {
        return tarea;
    }

    @Override
    public String toString() {
        return "Tasca{" + "dia=" + dia + ", tarea=" + tarea + '}';
    }
    
    
}


