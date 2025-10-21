import java.util.Scanner;

/**
 * ACT3.7: Crear una calculadora simple
 *
 * @author Tomeu Vives
 */

public class ACT3_1_07{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char operacion;
		int numero1, numero2;
		float resultado=0;
		
		System.out.println("Operación:");
		System.out.println("Suma (+)");
		System.out.println("Resta (-)");
		System.out.println("Multiplicación (*)");
		System.out.println("División (/)");	
		operacion = scanner.next().charAt(0);

		System.out.println("Introduzca el primer número:");
		numero1 = scanner.nextInt();
		System.out.println("Introduzca el segundo número:");
		numero2 = scanner.nextInt();
		
		if (operacion == '+') {
			resultado = numero1 + numero2;
		} else if (operacion == '-') {
			resultado = numero1 - numero2;
		} else if (operacion == '*') {
			resultado = numero1 * numero2;
		} else if (operacion == '/') {
			resultado = (float) numero1 / (float) numero2;
		}
		
		System.out.println("El resultado de la " + operacion + " es: " + resultado);
	}
}
