package EXTRAORD;

abstract class Vehicle {
    protected String matricula;
    protected float kilometratge;

    public Vehicle(String matricula, float kilometratge) {
        this.matricula = matricula;
        this.kilometratge = kilometratge;
    }

    public abstract boolean necessitaManteniment();

    @Override
    public String toString() {
        return "matricula=" + this.matricula + ", kilometratge=" + this.kilometratge + ", Manteniment=" + (this.necessitaManteniment() ? "Si" : "No") ;
    }
    
}