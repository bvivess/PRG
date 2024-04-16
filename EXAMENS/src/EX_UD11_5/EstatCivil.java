package EX_UD11_5;

public enum EstatCivil {
    CASAT("Casat","Casado","Married"),
    FADRI("Fadrí","Soltero","Single");
    
    private final String descripcioCA;
    private final String descripcioES;
    private final String descripcioEN;

    private EstatCivil(String descripcioCA, String descripcioES, String descripcioEN) {
        this.descripcioCA = descripcioCA;
        this.descripcioES = descripcioES;
        this.descripcioEN = descripcioEN;
    }

    public String getDescripcioCA() {
        return descripcioCA;
    }

    public String getDescripcioES() {
        return descripcioES;
    }

    public String getDescripcioEN() {
        return descripcioEN;
    }
    
}
