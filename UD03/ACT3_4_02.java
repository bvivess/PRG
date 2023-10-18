public class ACT3_4_02 {
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
		
		// Imprimir el contingut de la diagonal secundària 
		System.out.println();
		System.out.print("[ ");
        for (int i = 0, j=matriu.length-1; i < matriu.length; i++, j--) {
			System.out.print(matriu[i][j] + " ");
        }
		System.out.print("]");
    }
}
