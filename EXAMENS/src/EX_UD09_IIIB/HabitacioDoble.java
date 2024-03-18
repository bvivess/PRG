package EX_UD09_IIIB;

class HabitacioDoble extends Habitacio {

    public HabitacioDoble(int idHabitacio, int numPax, boolean reservada, double preu) {
        super(idHabitacio, numPax, reservada, preu);
    }

    @Override
    public String toString() {
        return "Habitació Doble: " + super.toString();
    }
    
}
