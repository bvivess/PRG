package ex_extraordinario.Classes;

import java.util.Objects;

public class Vehiculo {
    private String matricula;
    private String modelo;
    private int anyo;
    private String color;
    private Combustible combustible;
    private Marca marca;

    public Vehiculo(String matricula, String modelo, int anyo, String color, Combustible combustible, Marca marca) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.anyo = anyo;
        this.color = color;
        this.combustible = combustible;
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.matricula, other.matricula);
    }
    
    // getters, setters 

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", modelo=" + modelo + ", anyo=" + anyo + ", color=" + color + ", combustible=" + combustible + ", marca=" + marca + '}';
    }
    
}
