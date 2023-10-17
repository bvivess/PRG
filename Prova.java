import java.util.Arrays;
public class Prova {

	public static void main ( String [] args ) {
		int[][] numeros = {{  1,  2,  3,  4,  5,  6,  7,  8,  9, 10},  // correspon a una 
						   { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},  // declaració següent
						   { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30},  // int[4][10] 
						   { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40}}; // 4 files, 10 columnes
		int nfiles = numeros.length;       // torna el nombre de files
		int ncolumnes = numeros[0].length; // torna el nombre de columnes
		
		System.out.println(nfiles);
		System.out.println(ncolumnes);
	}
}
