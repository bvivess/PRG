package ACT9_0E;

/**
 *
 * @author winadmin
 */
interface Coloreador {
    void aplicarColor(String color);  // declarar, no implementar

    default String __toString() {  // mètode per defecte: no es poden emprar els mètodes d''Object'
        return "Això és un Coloreador";
    }

}
