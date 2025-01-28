package EXTRAORD;

import java.util.ArrayList;
import java.util.Objects;

abstract class Vehicle {
    protected String matricula;
    protected float kilometratge;

    public Vehicle(String matricula, float kilometratge) {
        this.matricula = matricula;
        this.kilometratge = kilometratge;
    }

    public abstract boolean necessitaManteniment();

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Vehicle vehicle = (Vehicle) o;
        return this.matricula.equals(vehicle.matricula);
    }


    @Override
    public String toString() {
        return "matricula=" + this.matricula + ", kilometratge=" + this.kilometratge + ", Manteniment=" + (this.necessitaManteniment() ? "Si" : "No") ;
    }

    public String getMatricula() {
        return matricula;
    }
    
}