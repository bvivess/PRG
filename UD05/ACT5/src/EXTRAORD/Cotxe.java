package EXTRAORD;

import java.util.ArrayList;

class Cotxe extends Vehicle {
    private int places;

    public Cotxe(String matricula, float kilometratge, int places) {
        super(matricula, kilometratge);
        this.places = places;
    }

    @Override
    public boolean necessitaManteniment() {
        return kilometratge > 15000;
    }

    @Override
    public String toString() {
        return " Cotxe {" + super.toString() + ",places=" + this.places + '}';
    }
    
}