package EX_UD09_IIIB;

// Classe abstracta per representar una habitació
abstract class Habitacio {
    private int idHabitacio;
    private boolean reservada;
    private int numPax;
    private double preu;

    public Habitacio(int idHabitacio, int numPax, boolean reservada, double preu) {
        this.idHabitacio = idHabitacio;
        this.numPax = numPax;
        this.reservada = reservada;
        this.preu = preu;
    }

    public int getIdHabitacio() {
        return idHabitacio;
    }

    public boolean getReservada() {
        return reservada;
    }
    
    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }
    
    public int getNumPax() {
        return numPax;
    }

    public double getPreu() {
        return preu;
    }

    @Override
    public String toString() {
        return "Habitacio {" + "idHabitacio=" + idHabitacio + ", reservada=" + reservada + ", numPax=" + numPax + ", preu=" + preu + '}';
    }
    
}
