package ACT10_5;

import java.util.Objects;


// Classe Vehicle
class Vehicle {
    private String matricula;
    private String marca;
    private String model;
    private int any;
    private EstatReparacio estat;

    public Vehicle(String matricula, String marca, String model, int any) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.any = any;
        this.estat = EstatReparacio.PENDENT; // inicialitza amb PENDENT
    }

    // Getters i setters
    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModel() { return model; }
    public int getAny() { return any; }
    public EstatReparacio getEstat() { return estat; }
    public void setEstat(EstatReparacio estat) { this.estat = estat; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle v = (Vehicle) o;
        return matricula.equals(v.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Vehicle {" + "matricula=" + this.matricula + ", marca=" + this.marca + ", model=" + this.model + ", any=" + this.any + ", estat=" + this.estat.getDescripcio() + '}';
    }
    
}

