package ACT4_2;

import ACT4_1.UtilitatsArrays;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 10x10:
  *     Inicialitza-la de forma que cada casella tengui un valor aleatori.
  */
public class ACT4_2_01 {

    public static void main(String[] args) {
        final int MIDA=10;
        int[][] matriu = generaMatriu(MIDA, 10, 100);

        System.out.println();
        UtilitatsMatrius.mostraMatriu(matriu);
    }
    
    /**
     * Assigna a cada posicio de 
     * @param longitud
     * @param minim
     * @param maxim
     * @return matriu
     */
    public static int[][] generaMatriu(int longitud, int minim, int maxim) {
        int[][] matriu = new int[longitud][longitud];
        
        for (int i = 0; i < matriu.length; i++) {
            matriu[i] = UtilitatsArrays.generaArray(longitud, minim, maxim);
        }
        return matriu;
    }
}
