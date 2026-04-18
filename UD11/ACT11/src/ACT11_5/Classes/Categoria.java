package ACT11_5.Classes;

public enum Categoria {
    ALIMENTACIO, 
    ELECTRONICA, 
    ROBA;
    
    @Override
    public String toString() {
        return name();
    }
}
