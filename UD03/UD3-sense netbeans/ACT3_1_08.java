/**
 * ACT3.8: Calcular la suma dels 100 primers nombres parells
 *
 * @author Tomeu Vives
 */

public class ACT3_1_08{
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
