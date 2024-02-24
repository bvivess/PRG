import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Configuracion {

    // Atributo estático para almacenar la configuración
    private static String configuracion;

    // Bloque estático para cargar la configuración desde un archivo
    static {
        cargarConfiguracion();
    }

    // Método privado para cargar la configuración desde un archivo
    private static void cargarConfiguracion() {
        try (BufferedReader br = new BufferedReader(new FileReader("config.txt"))) {
            configuracion = br.readLine();
            System.out.println("Configuración cargada exitosamente: " + configuracion);
        } catch (IOException e) {
            System.err.println("Error al cargar la configuración: " + e.getMessage());
        }
    }

    // Método estático para obtener la configuración
    public static String getConfiguracion() {
        return configuracion;
    }

    public static void main(String[] args) {
        // Acceder a la configuración desde cualquier parte del programa
        String configuracion = Configuracion.getConfiguracion();
        System.out.println("Configuración obtenida desde la clase principal: " + configuracion);
    }
}
