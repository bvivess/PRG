package ACT8_0C2;

/**
 *
 * @author winadmin
 */
abstract class Coloreador {
    String color; 

    public Coloreador(String color) {
        this.color = color;
    }
    
    abstract void aplicaColor(String color);  // declarar, no implementar

}
