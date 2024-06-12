package EX_RECUPERACIO_13A;

public enum OrderMode {
    online ("online"),
    direct ("direct");
    
    private final String descripcio;

    private OrderMode(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getDescripcio() {
        return descripcio;
    }
    
}
