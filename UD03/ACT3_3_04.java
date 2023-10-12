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

        for (int i = 0; i < LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++) {
                array[i][j] = n;
                n++;
            }
        }

        // Imprimir el contingut de l'array
        for (int i = 0; i < LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println(); // Saltar a la siguiente fila
        }
    }
}
