/**
 * ACT3.8
 *
 * @author Tomeu Vives
 */

public class ACT3_8{
	public static void main(String[] args) {
		int resultado = 0;
		
		for (int i=1; i<=100; i=i+1) {
			if (i % 2 == 0) {
				resultado = resultado + i;
			}
		}
		System.out.println("El resultado es: " + resultado);
	}
}
