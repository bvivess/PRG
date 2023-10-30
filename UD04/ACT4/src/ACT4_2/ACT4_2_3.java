package ACT4_2;

/**
 * Crea una classe que inicialitzi una matriu quadrada, pe 5x5:
 *      Mostra la diagonal principal, [1,1], [2,2]...
 */

public class ACT4_2_3 {
     /**
     *
     * @param args Els arguments passats per la línia de comandes
     */
    public static void main(String[] args) {
        final int MIDA=5;
        int[][] matriu = UtilitatsMatrius.generaMatriu(MIDA, 10, 100);

        System.out.println();
        UtilitatsMatrius.mostrarMatriu(matriu);
        System.out.println();
        UtilitatsMatrius.mostrarDiagonalPrincipal(matriu);
    }
}
