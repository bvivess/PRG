package EX_UD11_5;

public enum EstatCivil {
    CASAT("Casat","Casado","Married"),
    FADRI("Fadrí","Soltero","Single");
    
    private String descripcioCA;
    private String descripcioES;
    private String descripcioEN;

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
