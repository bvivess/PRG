package ACT11_6B.Classes;

import java.time.LocalDate;

public class Reparacio {
    private int id;
    private LocalDate dataEntrada;
    private Vehicle vehicle;
    private String descripcio;
    private double cost;
    private EstatReparacio estat;

    public Reparacio(int id, LocalDate dataEntrada, Vehicle vehicle, String descripcio, double cost, EstatReparacio estat) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.vehicle = vehicle;
        this.descripcio = descripcio;
        this.cost = cost;
        this.estat = estat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public EstatReparacio getEstat() {
        return estat;
    }

    public void setEstat(EstatReparacio estat) {
        this.estat = estat;
    }

    @Override
    public String toString() {
        return "Reparacio{" + "id=" + id + ", dataEntrada=" + dataEntrada + ", vehicle=" + vehicle + ", descripcio=" + descripcio + ", cost=" + cost + ", estat=" + estat + '}';
    }


}