package ACT9_0E;

/**
 *
 * @author winadmin
 */
interface FiguraGeometrica {
    double calculaArea();  // declarar, no implementar

    default String _toString() {  // mètode per defecte: no es poden emprar els mètodes d''Object'
        return "Això és una figura";
    }

}
