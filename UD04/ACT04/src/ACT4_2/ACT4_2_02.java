package ACT4_2;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 10x10:
  *      Mostra-la per pantalla, cada fila a una línia.
  */
public class ACT4_2_02 {

    public static void main(String[] args) {
        final int MIDA=10;
        int[][] matriu = UtilitatsMatrius.generaMatriu(MIDA, 10, 100);

        System.out.println();
        UtilitatsMatrius.mostraMatriu(matriu);
    }
}
