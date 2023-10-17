public class ACT3_3_04 {
/**
 * Crear un array de 4x4
 *
 * @author Tomeu Vives
 */
    public static void main(String[] args) {
		final int LONGITUD = 4;
        int[][] array = new int[LONGITUD][LONGITUD];
        int n = 1;
		int suma = 0;

        for (int i = 0; i < LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++) {
                array[i][j] = n;
				n++;
            }
        }

        // Imprimir el contingut de l'array
	System.out.println("[");
        for (int[] fila : array) {
	    System.out.print("[ ");
            for (int f: fila) {
                System.out.print(f + " ");
		suma = suma + f;
            }
            System.out.println("]"); // Saltar a la siguiente fila
        }
	System.out.print("]");
	System.out.println();
	System.out.println("La suma és: " + suma);
    }
}
