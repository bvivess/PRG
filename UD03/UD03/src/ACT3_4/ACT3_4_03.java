package ACT3_4;

public class ACT3_4_03 {
/**
 * Crear un array de 4x4
 *
 * @author Tomeu Vives
 */
    public static void main(String[] args) {
		final int LONGITUD = 4;
        int[][] matriu = new int[LONGITUD][LONGITUD];

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = i+j;
            }
        }

        // Imprimir el contingut de la matriu
        System.out.println("[");
        for (int[] array : matriu) {
            System.out.print("[ ");
            for (int a: array) {
                System.out.print(a + " ");
            }
            System.out.println("]"); 
        }
		System.out.println("]");

        // Imprimir el contingut de la diagonal principal
        System.out.println();
        System.out.print("[ ");
        for (int i = 0; i < matriu.length; i++) {
            System.out.print(matriu[i][i] + " ");
        }
        System.out.println("]");
		
        // Imprimir el contingut de la diagonal secund?ria 
        System.out.println();
        System.out.print("[ ");
        for (int i = 0, j=matriu.length-1; i < matriu.length; i++, j--) {
            System.out.print(matriu[i][j] + " ");
        }
        // o també:
        for (int i = 0; i < matriu.length; i++) {
            System.out.println(matriu[i][(matriu.length-1) - i] + " ");
        }
        System.out.print("]");
        
        // Imprimir 2 columnes aleat?ries, p.e. 1 i 3
        int[] COL = {0,3};
        for (int c=0; c < COL.length; c++)
                for (int i = 0; i < matriu.length; i++) 
                        System.out.print(matriu[i][COL[c]] + " ");
        
    }
}
