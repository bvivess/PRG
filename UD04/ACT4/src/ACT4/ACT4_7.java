package ACT4;
/**
 *     7. Crea una classe que defineixi una matriu quadrada, pe 4x4, i un mètode per a cada una d'aquestes opcions.
 *         1. Inicialitza-la de forma que cada casella tengui la suma de les seves coordenades.
 *         2. Mostra-la per pantalla, cada fila a una línia.
 *         3. Mostra la diagonal principal, [1,1], [2,2]...
 *         4. Mostra la diagonal secundària [4,1][3,2]...
 */
public class ACT4_7 {
     /**
     *
     * @param args Els arguments passats per la línia de comandes
     */
    public static void main(String[] args) {
        final int MIDA=5;
        int[][] matriu = UtilitatsMatrius.generaMatriu(MIDA, 10, 100);;

        System.out.println();
        UtilitatsMatrius.mostrarMatriu(matriu);
        System.out.println();
        UtilitatsMatrius.mostrarDiagonalPrincipal(matriu);
        System.out.println();
        UtilitatsMatrius.mostrarDiagonalSecundaria(matriu);
    }
}
