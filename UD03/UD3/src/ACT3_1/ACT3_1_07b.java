package ACT3_1;

import java.util.Scanner;

/**
 * ACT3.7: Crear una calculadora simple
 *
 * @author Tomeu Vives
 */

public class ACT3_1_07b{
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		char operacion;
		int numero1, numero2, resultado=0;
		
		operacion = LeerOperacion();
		numero1 = LeerOperador("Introduzca el primer número:");
		numero2 = LeerOperador("Introduzca el segundo número:");
		Calcular(operacion, numero1, numero2);		
	}
	
	private static char LeerOperacion() {
		char operacion;
		System.out.println("Operación:");
		System.out.println("Suma (+)");
		System.out.println("Resta (-)");
		System.out.println("Multiplicación (*)");
		System.out.println("División (/)");	
		operacion = scanner.next().charAt(0);
		
		return operacion;
	}
	
	private static int LeerOperador(String text) {
		int operador;
		System.out.println(text);
		operador = scanner.nextInt();
		
		return operador;
	}
	
	private static void Calcular(char operacion, int op1, int op2) {
		float resultado=0;
		
		if (operacion == '+') {
			resultado = op1 + op2;
		} else if (operacion == '-') {
			resultado = op1 - op2;
		} else if (operacion == '*') {
			resultado = op1 * op2;
		} else if (operacion == '/') {
			resultado = (float) op1 / (float) op2;
		}
		System.out.println("El resultado de la " + operacion + " es: " + resultado);
	}
}
