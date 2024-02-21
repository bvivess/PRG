package ACT9_7;

/**
 *
 * @author winadmin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
------------------




// Part 2: CLIENTS DE LA BIBLIOTECA

class ClientBiblioteca {
    private String nom;
    private String cognom;
    private ArrayList<Llibre> llibresPrestats;

    public ClientBiblioteca(String nom, String cognom) {
        this.nom = nom;
        this.cognom = cognom;
        this.llibresPrestats = new ArrayList<>();
    }

    public void prestarLlibre(Llibre llibre) {
        llibresPrestats.add(llibre);
    }

    // Getters i setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public ArrayList<Llibre> getLlibresPrestats() {
        return llibresPrestats;
    }

    public void setLlibresPrestats(ArrayList<Llibre> llibresPrestats) {
        this.llibresPrestats = llibresPrestats;
    }
}

// Part 3: MAIN

public class MainBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Afegir alguns llibres a la biblioteca
        biblioteca.afegirLlibre(new Llibre("El Senyor dels Anells", "J.R.R. Tolkien", 1954, 25.0));
        biblioteca.afegirLlibre(new Llibre("Cien a?os de soledad", "Gabriel García Márquez", 1967, 20.0));
        biblioteca.afegirLlibre(new Llibre("1984", "George Orwell", 1949, 18.0));

        // Mostrar els llibres disponibles a la biblioteca
        biblioteca.mostrarLlibres();

        // Crear un client de la biblioteca
        ClientBiblioteca client = new ClientBiblioteca("Anna", "Martínez");

        // Prestar alguns llibres al client
        Llibre llibrePrestat1 = biblioteca.buscarLlibre("El Senyor dels Anells");
        Llibre llibrePrestat2 = biblioteca.buscarLlibre("Cien a?os de soledad");

        if (llibrePrestat1 != null) {
            client.prestarLlibre(llibrePrestat1);
        }

        if (llibrePrestat2 != null) {
            client.prestarLlibre(llibrePrestat2);
        }

        // Mostrar els llibres prestats pel client
        System.out.println("\nLlibres prestats per " + client.getNom() + " " + client.getCognom() + ":");
        for (Llibre llibre : client.getLlibresPrestats()) {
            System.out.println(llibre);
        }
    }
}
