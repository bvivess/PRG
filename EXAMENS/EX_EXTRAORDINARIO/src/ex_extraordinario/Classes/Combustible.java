package ex_extraordinario.Classes;

public enum Combustible {
    GASOLINA ("Gasolina"),
    DIESEL ("Diesel"),
    ELECTRICO ("Electrico");

    private final String description; 

    Combustible(String description) { 
        this.description = description;
    }
    
    public String getDescription() { 
        return this.description;
    }
}