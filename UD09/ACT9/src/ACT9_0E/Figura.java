package ACT9_0E;

/**
 *
 * @author winadmin
 */
interface Figura {
    double calcularArea();  // declarar, no implementar

    default String _toString() {  // no es poden emprar els mètodes d''Object'
        return "Això és una figura";
    }

}
