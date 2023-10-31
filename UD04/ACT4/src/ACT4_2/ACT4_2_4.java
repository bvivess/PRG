package ACT4_2;

import ACT4_1.UtilitatsArrays;

/**
 * Crea una classe que inicialitzi una matriu quadrada, pe 10x10:
 *      Mostra la diagonal secundària [10,0][9,1][8,2]...
 */
public class ACT4_2_4 {
     /**
     *
     * @param args Els arguments passats per la línia de comandes
     */
    public static void main(String[] args) {
        final int MIDA=10;
        int[][] matriu = UtilitatsMatrius.generaMatriu(MIDA, 10, 100);
        int[] diagonal;

        System.out.println();
        UtilitatsMatrius.mostrarMatriu(matriu);
        System.out.println();
        diagonal = UtilitatsMatrius.generaDiagonalSecundaria(matriu);
        UtilitatsArrays.mostraArray(diagonal);
    }
}
