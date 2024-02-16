package ACT9_3A;

// Clase principal Main
public class Main {
    public static void main(String[] args) {
        Llibre libro = new Llibre("Java Programming", 2020, "John Smith", 35.0);
        Revista revista = new Revista("Tech Magazine", 2021, 25, 10.0);

        // Array de Publicaciones
        Publicacio[] publicaciones = {libro, revista};

        // Polimorfismo
        for (Publicacio publicacion : publicaciones) {
            publicacion.mostrarInformacion();
            System.out.println("Precio: $" + publicacion.calcularPrecio());
            System.out.println("--------------");
        }
    }
}



