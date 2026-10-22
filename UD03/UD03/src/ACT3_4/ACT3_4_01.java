package ACT3_4;

import java.util.Scanner;

public class ACT3_4_01 {
/**
 *
 * @author Tomeu Vives
 */
    public static void main(String[] args) {
        int[][] matriu = new int[4][4];


        // Carrega la matriu
        for (int i = 0; i < matriu.length; i++)
            for (int j = 0; j < matriu[0].length; j++) 
                matriu[i][j] = i+j;
        
        // for 'indexat'
        for (int i = 0; i < matriu.length; i++)
            for (int j = 0; j < matriu[0].length; j++)
                System.out.print(matriu[i][j]);
        
        // for 'foreach'
        for (int[] array : matriu)
            for (int a : array)
                System.out.print(a);

    }   
}
