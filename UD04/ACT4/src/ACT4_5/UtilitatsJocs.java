package ACT4_5;

/**
 *
 * @author winadmin
 */
public class UtilitatsJocs {
   public static void mostrarTauler(int[][] matriu, int posicio) {
        String car;
        for (int i = 0; i < matriu.length; i++) {
            System.out.print('|');
            for (int j = 0; j < matriu[i].length; j++) {
                if (matriu[i][j] == 0) {
                    car = "   ";
                } else if (matriu[i][j] == 1) {
                    car = " . ";
                } else if (matriu[i][j]==99) {
                    car = " * ";
                } else if (matriu[i][j]==posicio) {
                    car = " O ";
                } else {
                    car = " - ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
}
