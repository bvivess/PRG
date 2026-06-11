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
}
