package ACT4_2;

import ACT4_1.UtilitatsArrays;

/**
 * Crea una classe que inicialitzi una matriu quadrada, pe 10x10:
 *      Mostra la diagonal principal: [0,0] [1,1], [2,2]...
 */

public class ACT4_2_03 {

    public static void main(String[] args) {
        final int MIDA=10;
        int[][] matriu = UtilitatsMatrius.generaMatriu(MIDA, 10, 100);
        int[] diagonal;

        System.out.println();
        UtilitatsMatrius.mostrarMatriu(matriu);
        System.out.println();
        diagonal = UtilitatsMatrius.generaDiagonalPrincipal(matriu);
        UtilitatsArrays.mostraArray(diagonal);
    }
}
