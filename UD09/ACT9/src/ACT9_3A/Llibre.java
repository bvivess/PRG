package ACT9_3A;

/**
 *
 * @author winadmin
 */
// Clase Libro
class Llibre extends PublicacioBase {
    private String autor;
    private double precio;

    public Llibre(String titulo, int anioPublicacion, String autor, double precio) {
        super(titulo, anioPublicacion);
        this.autor = autor;
        this.precio = precio;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Libro: " + getTitulo() + ", Autor: " + autor + ", A?o: " + getAnioPublicacion());
    }

    @Override
    public double calcularPrecio() {
        return precio;
    }
}
