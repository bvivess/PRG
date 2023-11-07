package Formes;

public class Rectangle extends Forma {
    private double longitud;
    private double amplada;

	// Constructor de Rectangle
    public Rectangle(String color, double longitud, double amplada) {
        super(color);
        this.longitud = longitud;
        this.amplada = amplada;
    }

    @Override
    public double calcularArea() {
        return longitud * amplada;
    }
	
	@Override
    public double calcularPerimetre() {
        return (longitud * 2)+(amplada*2);
    }
	
}