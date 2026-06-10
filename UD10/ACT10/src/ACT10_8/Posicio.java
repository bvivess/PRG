package ACT10_8;

import java.util.Objects;

public class Posicio {

    private int fila;
    private int columna;

    public Posicio(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Posicio p))
            return false;

        return fila == p.fila && columna == p.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }
}