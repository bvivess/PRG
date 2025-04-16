package ACT11_5;

public enum ValorsConnexio {
    SERVER ("SERVER"),
    DBASE ("DBASE"),
    USER ("USER"),
    PASSWD ("PASSWD");
    
    private final String abreviacio; // atribut

    ValorsConnexio(String abreviacio) { // constructor
        this.abreviacio = abreviacio;
    }
    public String getAbreviacio() { // getter
        return this.abreviacio;
    }

}
