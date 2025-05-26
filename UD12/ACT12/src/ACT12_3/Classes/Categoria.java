package ACT12_3.Classes;

public enum Categoria {
    ALIMENTACIO, 
    ELECTRONICA, 
    ROBA;
    
    @Override
    public String toString() {
        return name();
    }
}
