public class ACT3_3_04 {
/**
 * Crear un array de 4x4
 *
 * @author Tomeu Vives
 */
    public static void main(String[] args) {
		final int LONGITUD = 4;
        int[][] matriu = new int[LONGITUD][LONGITUD];
        int n = 1;
		int suma = 0;

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = n;
				n++;
            }
        }

        // Imprimir el contingut de la matriu
		System.out.println("[");
        for (int[] array : matriu) {
			System.out.print("[ ");
            for (int a: array) {
                System.out.print(a + " ");
				suma = suma + a;
            }
            System.out.println("]"); 
        }
		System.out.print("]");
		System.out.println();
		System.out.println("La suma és: " + suma);
    }
}
