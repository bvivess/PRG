package ACT4_2;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 10x10:
  *     Inicialitza-la de forma que cada casella tengui un valor aleatori.
  */
public class ACT4_2_1 {
     /**
     *
     * @param args Els arguments passats per la línia de comandes
     */
    public static void main(String[] args) {
        final int MIDA=10;
        int[][] matriu = UtilitatsMatrius.generaMatriu(MIDA, 10, 100);

        System.out.println();
        UtilitatsMatrius.mostrarMatriu(matriu);
    }
}
