package EXAMEN;

/**
 *
 * @author Tomeu Vives
 */
public class UtilitatsMatrius {
    // ACT4_2
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
    
    public static void mostraMatriu(int[][] matriu) {
        String separador = "  ";
        System.out.println('[');
        for (int i = 0; i < matriu.length; i++) {
            System.out.print(separador);
            UtilitatsArrays.mostraArray(matriu[i]); 
            separador = ", ";
        }
        System.out.println(']');
    }
 
    // ACT4_2
    /**
     * Mostra per consola la diagonal principal de la matriu
     * @param matriu
     */
    public static int[] generaDiagonalPrincipal(int[][] matriu) {
        int[] sortida = new int[matriu.length];
        
        for (int i = 0; i < matriu.length; i++) {
            sortida[i] = matriu[i][i];
        }
        return sortida;
    }
 
    // ACT4_2
    /**
     * Mostra per consola la diagonal secundaria de la matriu
     * @param matriu
     */
    public static int[] generaDiagonalSecundaria(int[][] matriu) {
        int[] sortida = new int[matriu.length];
        
        for (int i = 0, j=matriu.length-1; i < matriu.length; i++, j--) {
            sortida[i] = matriu[i][j];
        }
        return sortida;
    }
    
    // ACT4_2
    /**
     * Genera un array associat a una fila
     * @param matriu
     */
    public static int[] generaFila(int[][] matriu, int x) {

        return matriu[x];
    }
    
    // ACT4_2
    /**
     * Genera un array associat a una columna
     * @param matriu
     */    
    public static int[] generaColumna(int[][] matriu, int y) {
        int[] sortida = new int[matriu.length];
        
        for (int i = 0; i < matriu.length; i++) {
            sortida[i] = matriu[i][y];
        }
        return sortida;
    }

}
