package ex_final;

import java.io.Serializable;

public class Activitat implements Serializable {
    private String codi;
    private String descripcio;
    private int durada;
    private Dificultat dificultat;

    public Activitat(String codi, String descripcio, int durada, Dificultat dificultat) {
        this.codi = codi;
        this.descripcio = descripcio;
        this.durada = durada;
        this.dificultat = dificultat;
    }

    public String getCodi() { return codi; }
    public String getDescripcio() { return descripcio; }
    public int getDurada() { return durada; }
    public Dificultat getDificultat() { return dificultat; }

    @Override
    public String toString() {
        return "[" + codi + "] " + descripcio + " (" + durada + "h, " + dificultat + ")";
    }
}

