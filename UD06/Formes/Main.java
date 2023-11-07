package Formes;

public class Main {
	
    public static void main(String[] args) {
        Forma rectangle = new Rectangle("Vermell", 5, 3);
        Forma cercle = new Cercle("Blau", 4);
        Forma triangle = new Triangle("Verd", 6, 4);

        Forma[] formes = {rectangle, cercle, triangle};

        for (Forma forma : formes) {
            System.out.println("Color: " + forma.getColor());
            System.out.println("Àrea: " + forma.calcularArea());
			System.out.println("Perímetre: " + forma.calcularPerimetre());

            if (forma instanceof Dibuixable) {
                ((Dibuixable) forma).dibuixar();
            } else {
                System.out.println("Aquesta forma no és dibuixable.");
            }

            System.out.println();
        }
    }
	
}

