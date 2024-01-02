package ACT9_0E;

/**
 *
 * @author winadmin
 */
interface Figura {
    double calcularArea();  // declarar, no implementar

    default String _toString() {  // mètode propi de la interficie 'Colorear'
        return "Això és una figura";
    }

}
