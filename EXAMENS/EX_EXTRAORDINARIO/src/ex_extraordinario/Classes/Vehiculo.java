package ex_extraordinario.Classes;

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
