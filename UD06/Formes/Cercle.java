package Formes;

public class Cercle extends Forma implements Dibuixable {
    private double radi;

	// Constructor de 'Cercle'
    public Cercle(String color, double radi) {
        super(color);
        this.radi = radi;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radi * radi;
    }
	
    @Override
    public double calcularPerimetre() {
        return Math.PI * radi * 2;
    }
	
    @Override
    public void dibuixar() {
        System.out.println("Dibuixant un cercle de color " + getColor() + " amb radi " + radi);
    }
	
}