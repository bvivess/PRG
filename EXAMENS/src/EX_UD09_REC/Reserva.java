package EX_UD09_REC;

import java.util.ArrayList;

// Classe Reserva per modelar els clients de l'hotel
class Reserva implements EsReserva{
    private int idReserva;
    private Persona titular;
    private ArrayList<Habitacio> habitacions;

    public Reserva(int idReserva, Persona titular, ArrayList<Habitacio> habitacions) {
        this.idReserva = idReserva;
        this.titular = titular;
        this.habitacions = habitacions;
    }

    @Override
    public Habitacio cercaHabitacio(Hotel hotel, int numPax) {
        for (Habitacio h : hotel.habitacions) 
            if (!h.getReservada())
                if (h.getNumPax() >= numPax)
                    return h;
        return null;
    }

    @Override
    public boolean afegeixHabitacio(Hotel hotel, int numPax) {
        Habitacio h = cercaHabitacio(hotel, numPax);
        
        if (h != null) {
            this.habitacions.add(h);
            h.setReservada(true);
            return true;
        } else 
            return false;
    }

    @Override
    public double calculaPreu() {
        double preuTotal = 0;
        
        for (Habitacio h : this.habitacions)
            preuTotal += h.getPreu();
        
        return preuTotal * 1.21;
    }

    public ArrayList<Habitacio> getHabitacions() {
        return this.habitacions;
    }
    
    @Override
    public String toString() {
        return "Reserva{" + "IDReserva=" + idReserva + ", Titular=" + titular + ",\n\tHabitació={" + this.habitacions.toString() + "}";
    }
    
}
