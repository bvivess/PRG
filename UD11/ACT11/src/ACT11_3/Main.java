package ACT11_3;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.afegeixLlibre("El Quijote", "Miguel de Cervantes", 1605);
        biblioteca.afegeixLlibre("Don Segundo Sombra", "Ricardo Güiraldes", 1926);
        biblioteca.afegeixLlibre("La Sombra del Viento", "Carlos Ruiz Zafón", 2001);

        biblioteca.mostraLlibresDisponibles();

        biblioteca.prestaLlibre(new Llibre("El Quijote", "Miguel de Cervantes", 1605));

        biblioteca.mostraLlibresDisponibles();
        biblioteca.mostraLlibresPrestats();

        biblioteca.tornaLlibre();

        biblioteca.mostraLlibresDisponibles();
        biblioteca.mostraLlibresPrestats();
    }
}


import java.time.LocalDate;
import java.util.*;






