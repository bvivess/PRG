package ACT8_0E;

/**
 *
 * @author winadmin
 */
// Classe Abstracta 
abstract class FiguraGeometrica {
    String color;  // Totes les figures tenen un color
    
    abstract double calculaArea();  // declarar, no implementar
    abstract double calculaPerimetre(); 
    
    // Constructor
    public FiguraGeometrica(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "El color de la figura es: " + color;
    }
    

}

