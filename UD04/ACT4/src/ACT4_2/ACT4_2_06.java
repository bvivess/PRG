package ACT4_2;

import ACT4_1.UtilitatsArrays;

/**
 * Crea una classe que inicialitzi una matriu quadrada, pe 10x10:
 *      Mostra la diagonal secundària [10,0][9,1][8,2]...
 */
public class ACT4_2_06 {

    public static void main(String[] args) {
        final int MIDA=10;
        int[][] matriu = UtilitatsMatrius.generaMatriu(MIDA, 10, 100);
        int[] fila;

        System.out.println();
        UtilitatsMatrius.mostrarMatriu(matriu);
        System.out.println();
        fila = UtilitatsMatrius.generaColumna(matriu, 2);
        UtilitatsArrays.mostraArray(fila);
    }
}
