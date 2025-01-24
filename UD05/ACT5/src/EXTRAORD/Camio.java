package EXTRAORD;

class Camio extends Vehicle {
    private double capacitatCarga;

    public Camio(String matricula, float kilometratge, float capacitatCarga) {
        super(matricula, kilometratge);
        this.capacitatCarga = capacitatCarga;
    }

    @Override
    public boolean necessitaManteniment() {
        return kilometratge > 30000;
    }
    
    @Override
    public String toString() {
        return " Camió {" + super.toString() + ", càrrega=" + this.capacitatCarga + '}';
    }
    
}