package Formes;

public class Triangle extends Forma {
    private double base;
    private double alcada;

	// Constructor de Triangle
    public Triangle(String color, double base, double alcada) {
        super(color);
        this.base = base;
        this.alcada = alcada;
    }

    @Override
    public double calcularArea() {
        return (base * alcada) / 2;
    }
	
    @Override
    public double calcularPerimetre() {
        return (base * 3);
    }
}