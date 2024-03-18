package EX_UD09_REC;

public interface EsReserva {
    public abstract Habitacio cercaHabitacio(Hotel hotel, int numPax);

    public abstract boolean afegeixHabitacio(Hotel hotel, int numPax);

    public abstract double calculaPreu();
    
}
