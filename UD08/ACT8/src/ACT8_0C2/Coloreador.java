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
    
    // Implementació del mètode concret de 'Coloreador'
    public void aplicaColor(String color) {
        this.color = color;
    }

}
