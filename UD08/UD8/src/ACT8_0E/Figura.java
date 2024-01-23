package ACT8_0E;

/**
 *
 * @author winadmin
 */
// Classe Abstracta 
abstract class Figura {
    String color;  // Totes les figures tenen un color
    
    abstract double calcularArea();  // declarar, no implementar
    abstract double calcularPerimetre(); 
    
    // Constructor
    public Figura(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "El color de la figura es: " + color;
    }
    

}

