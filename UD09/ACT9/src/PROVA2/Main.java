package PROVA2;

/**
 *
 * @author gt
 */
public class Main {
    public static void main(String[] args) {
        MiClase instancia1 = new MiClase();
        instancia1.metodoPorDefecto(); // Salida: Implementación por defecto en la interfaz

        OtraClase instancia2 = new OtraClase();
        instancia2.metodoPorDefecto(); // Salida: Implementación personalizada en OtraClase
    }
}