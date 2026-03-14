package ACT8_7;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        // 1. Crear un client de la biblioteca
        Client client = new Client("Anna Martínez");
        biblioteca.afegeixClient(client);
        // 2. Afegir alguns llibres a la biblioteca
        biblioteca.afegeixLlibreDisponible(new Llibre("El Senyor dels Anells", "J.R.R. Tolkien", 1954, 25.0));
        biblioteca.afegeixLlibreDisponible(new Llibre("Cien a?os de soledad", "Gabriel García Márquez", 1967, 20.0));
        biblioteca.afegeixLlibreDisponible(new Llibre("1984", "George Orwell", 1949, 18.0));
        // 3. Mostrar els llibres de la biblioteca
        System.out.println(biblioteca.toString());
        
        System.out.println("------------------------------");
        
        // 4. Presta llibre
        biblioteca.prestaLlibre("Anna Martínez", "El Senyor dels Anells");
        // 5. Mostrar els llibres de la biblioteca
        System.out.println(biblioteca.toString());
    }
}
