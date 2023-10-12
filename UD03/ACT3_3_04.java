public class ACT3_3_04 {
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

        // Imprimir el contenido del array
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println(); // Saltar a la siguiente fila
        }
    }
}
