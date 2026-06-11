package ex_extraordinario;

public class Vehiculo {
    private int idVehiculo;
    private String modelo;
    private int anio;
    private String color;
    private Marca marca;

    public Vehiculo(int idVehiculo, String modelo, int anio,
                    String color, Marca marca) {
        this.idVehiculo = idVehiculo;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.marca = marca;
    }

    // getters, setters, equals y hashCode
}
