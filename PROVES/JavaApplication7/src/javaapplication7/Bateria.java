package javaapplication7;

public class Bateria {
    private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    private int capacidad;

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Bateria(String marca, int capacidad) {
        this.marca = marca;
        this.capacidad = capacidad;
    }
    
    public int duracionBateria() {
        if (capacidad < 3000) {
          return 16;
        } else {
          return 24;
        }
    }

}
