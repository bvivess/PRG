package EX_UD09_IIIB;

class HabitacioSimple extends Habitacio {

    public HabitacioSimple(int idHabitacio, int numPax, boolean reservada, double preu) {
        super(idHabitacio, numPax, reservada, preu);
    }
    
    @Override
    public String toString() {
        return "Habitació Simple: " + super.toString();
    }

}