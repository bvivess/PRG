package ACT4_4;

public class UtilitatsRecursivitatOrdenacioCerca {
    /**
     * Calcula la potencia d'un nombre.
     *
     * @param base
     * @param exponent
     * @return la base elevat a l'exponent
     */
    public static double calcularPotencia(int base, int exponent) {
        if (exponent == 1) {
            return base;
        } else {
            return (base * calcularPotencia(base, exponent -1));
        }
    }    
}

