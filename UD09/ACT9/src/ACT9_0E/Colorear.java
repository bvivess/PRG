package ACT9_0E;

/**
 *
 * @author winadmin
 */
interface Colorear {
    void aplicarColor(String color);  // declarar, no implementar

    default String __toString() {  // mètode propi de la interficie 'Colorear'
        return "Això és un Coloreador";
    }

}
