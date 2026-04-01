package EX_3_1;

public enum EstatComanda {
    PENDENT("Pendent de preparar"),
    EN_PREPARACIO("En preparació"),
    SERVIDA("Servida"),
    COBRADA("Cobrada");

    private String descripcio;

    EstatComanda(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getDescripcio() {
        return this.descripcio;
    }
}