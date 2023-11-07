package Formes;

public abstract class Forma {
    private String color;

	// Constructor de 'Forma'
    public Forma(String color) {
        this.color = color;
    }

	// Getter de 'color'
    public String getColor() {
        return color;
    }

    public abstract double calcularArea();
	
	public abstract double calcularPerimetre();

}