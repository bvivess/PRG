/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package ACT8_0E;

/**
 *
 * @author winadmin
 */
class Cercle extends Figura {
    double radi;

    // Constructor
    public Cercle(String color, double radi) {
        super(color);
        this.radi = radi;
    }

    @Override
    double calcularArea() {
        return Math.PI * Math.pow(radi, 2);
    }

    @Override
    double calcularPerimetre() {
        return Math.PI * 2 * radi;
    }


    

}
