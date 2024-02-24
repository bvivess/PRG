package ordernararray;

import java.util.Arrays;

public class OrdernarArray {
	
	public static void main(String[] args) {
		
		int[] numeros = {7,4,5,2,1,10,8};

		imprimir(numeros);
		Arrays.sort(numeros);	
		imprimir(numeros);
		

	}
	
	
	public static void imprimir(int[] numeros){
		
		for (int numero:numeros)
			System.out.println(numero);
		
		System.out.println("-----");
		
	}

}