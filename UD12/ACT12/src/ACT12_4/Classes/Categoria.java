package ACT12_4.Classes;

public enum Categoria {
    ALIMENTACIO, 
    ELECTRONICA, 
    ROBA;
    
    @Override
    public String toString() {
        return name();
    }
}
