import java.util.Arrays;
public class Prova {
//public class LeyDeHondt {

    public static int[] asignarEscaños(int[] votos, int escaños) {
        int[] asignaciones = new int[votos.length];
        int[] cocientes = new int[votos.length];

        // Inicializamos el arreglo de asignaciones y el arreglo de cocientes.
        Arrays.fill(asignaciones, 0);
        Arrays.fill(cocientes, 0);

        // Procedemos a asignar los escaños uno por uno.
        for (int i = 0; i < escaños; i++) {
            int partidoGanador = -1;
            int maxCociente = -1;

            // Calculamos los cocientes para cada partido.
            for (int j = 0; j < votos.length; j++) {
                cocientes[j] = votos[j] / (asignaciones[j] + 1);
                if (cocientes[j] > maxCociente) {
                    maxCociente = cocientes[j];
                    partidoGanador = j;
                }
            }

            // Asignamos un escaño al partido con el cociente más alto.
            asignaciones[partidoGanador] = asignaciones[partidoGanador] + 1;
        }

		System.out.print("Asignaciones: ");
		for (int i=0; i<asignaciones.length; i++) {
			System.out.print(asignaciones[i] + " ");
		}

		System.out.print("Cocientes: ");
		for (int i=0; i<cocientes.length; i++) {
			System.out.print(cocientes[i] + " ");
		}
		System.out.println("");

        return asignaciones;
    }

    public static void main(String[] args) {
        int[] votos = {100000, 75000, 60000, 8}; // Ejemplo de votos para cuatro partidos.
        int escaños = 10; // Ejemplo de 8 escaños a asignar.

        int[] asignaciones = asignarEscaños(votos, escaños);

        for (int i = 0; i < asignaciones.length; i++) {
            System.out.println("Partido " + i + ": " + asignaciones[i] + " escaños.");
        }
    }
}
